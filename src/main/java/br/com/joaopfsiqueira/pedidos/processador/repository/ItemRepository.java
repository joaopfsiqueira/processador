package br.com.joaopfsiqueira.pedidos.processador.repository;

import br.com.joaopfsiqueira.pedidos.processador.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<ItemPedido, UUID> {
}
