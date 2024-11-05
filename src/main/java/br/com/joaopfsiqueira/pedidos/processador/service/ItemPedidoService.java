package br.com.joaopfsiqueira.pedidos.processador.service;

import br.com.joaopfsiqueira.pedidos.processador.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService {

    private final ItemRepository itemRepository;

    public ItemPedidoService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
}
