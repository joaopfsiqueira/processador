package br.com.joaopfsiqueira.pedidos.processador.service;

import br.com.joaopfsiqueira.pedidos.processador.entity.ItemPedido;
import br.com.joaopfsiqueira.pedidos.processador.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    public final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void save(List<ItemPedido> itens) {
        itens.forEach(item -> {
            produtoRepository.save(item.getProduto()); // salva o produto no banco, o produto está na entity
        });
    }
}
