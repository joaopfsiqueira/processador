package br.com.joaopfsiqueira.pedidos.processador.entity;

import br.com.joaopfsiqueira.pedidos.processador.entity.ItemPedido;
import br.com.joaopfsiqueira.pedidos.processador.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //
@Table(name = "pedido")
public class Pedido {

    @Id
    private UUID id = UUID.randomUUID();
    private String cliente;

    @OneToMany(mappedBy = "pedido") // um pedido tem muitos itens
    private List<ItemPedido> itens  = new ArrayList<>();

    @Column(name = "valor_total")
    private Double valorTotal;

    @Column(name = "email_notificacao")
    private String emailNotificacao;

    @Enumerated(EnumType.STRING) // salva o nome do enum no banco de dados
    private Status status = Status.EM_PROCESSAMENTO;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHora = LocalDateTime.now(); // na criação do pedido, a data e hora atual é atribuída


}
