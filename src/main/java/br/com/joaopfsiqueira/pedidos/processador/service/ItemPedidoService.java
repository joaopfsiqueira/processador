package br.com.joaopfsiqueira.pedidos.processador.service;

import br.com.joaopfsiqueira.pedidos.processador.entity.ItemPedido;
import br.com.joaopfsiqueira.pedidos.processador.entity.Pedido;
import br.com.joaopfsiqueira.pedidos.processador.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemRepository itemRepository;

    public ItemPedidoService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemPedido> save(List<ItemPedido> itens) {
        return itemRepository.saveAll(itens);
    }

    // diferente do metodo acima ele não salva um vetor inteiro, ele salva apenas um elemento!
    public void save(ItemPedido itemPedido) {
        itemRepository.save(itemPedido);
    }

    public void updatedItemPedido(List<ItemPedido> itemPedidos, Pedido pedido) {
        itemPedidos.forEach(item -> {
            item.setPedido(pedido); // informando ao item o seu pedido!
            itemRepository.save(item);
        });
    }
}
