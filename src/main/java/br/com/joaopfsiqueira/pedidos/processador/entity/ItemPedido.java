package br.com.joaopfsiqueira.pedidos.processador.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne
    private Produto produto;

    private Integer quantidade;

    @ManyToOne
    private Pedido pedido;
}
