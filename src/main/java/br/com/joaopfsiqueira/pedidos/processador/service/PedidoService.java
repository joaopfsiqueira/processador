package br.com.joaopfsiqueira.pedidos.processador.service;

import br.com.joaopfsiqueira.pedidos.processador.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
}
