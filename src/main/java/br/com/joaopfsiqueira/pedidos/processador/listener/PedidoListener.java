package br.com.joaopfsiqueira.pedidos.processador.listener;

import br.com.joaopfsiqueira.pedidos.processador.entity.Pedido;
import br.com.joaopfsiqueira.pedidos.processador.entity.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    // metodo que será chamado quando uma mensagem for recebida
    @RabbitListener(queues = "pedidos.v1.processamento")
    public void enviarNotificacao(Pedido pedido){
        pedido.setStatus(Status.PROCESSADO);
        logger.info("Notificacao gerada: {}", pedido.toString());
    }
}
