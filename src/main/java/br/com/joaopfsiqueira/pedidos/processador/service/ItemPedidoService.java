package br.com.joaopfsiqueira.pedidos.processador.service;

import br.com.joaopfsiqueira.pedidos.processador.entity.ItemPedido;
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
}
