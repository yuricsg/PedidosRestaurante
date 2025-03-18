package io.github.yuricsg.pedidosapi.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double valor;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

}
