package br.com.joaopfsiqueira.pedidos.processador.listener;

import br.com.joaopfsiqueira.pedidos.processador.entity.Pedido;
import br.com.joaopfsiqueira.pedidos.processador.entity.enums.Status;
import br.com.joaopfsiqueira.pedidos.processador.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final PedidoService pedidoService;

    public PedidoListener(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // metodo que será chamado quando uma mensagem for recebida
    @RabbitListener(queues = "pedidos.v1.processamento")
    public void enviarNotificacao(Pedido pedido){
        pedido.setStatus(Status.PROCESSADO);
        pedidoService.save(pedido);
    }
}
