package br.com.joaopfsiqueira.pedidos.processador.service;

import br.com.joaopfsiqueira.pedidos.processador.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    public final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
}
