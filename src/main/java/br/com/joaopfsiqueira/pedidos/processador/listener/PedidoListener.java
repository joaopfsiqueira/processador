package br.com.joaopfsiqueira.pedidos.processador.listener;

import br.com.joaopfsiqueira.pedidos.processador.entity.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    // metodo que será chamado quando uma mensagem for recebida
    @RabbitListener(queues = "pedidos.v1.notificacao")
    public void enviarNotificacao(Pedido pedido){
        logger.info("Notificacao gerada: {}", pedido.toString());
    }
}
