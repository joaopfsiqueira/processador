package br.com.joaopfsiqueira.pedidos.processador.service;

import br.com.joaopfsiqueira.pedidos.processador.entity.ItemPedido;
import br.com.joaopfsiqueira.pedidos.processador.entity.Pedido;
import br.com.joaopfsiqueira.pedidos.processador.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);
    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;
    private final ItemPedidoService itemPedidoService;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService, ItemPedidoService itemPedidoService) {
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
        this.itemPedidoService = itemPedidoService;
    }

    public void save(Pedido pedido){

        produtoService.save(pedido.getItens()); // pega os itens que estão dentro do pedido e salva no banco

        // salvamos os itens do pedido no banco e colocamos o retorno em uma lista
        List<ItemPedido> itemPedidos = itemPedidoService.save(pedido.getItens());

        // salvamos o pedido
        pedidoRepository.save(pedido);

        itemPedidoService.updatedItemPedido(itemPedidos, pedido); // atualiza os itens do pedido

        logger.info("Pedido salvo: {}", pedido.toString());
    }


}
