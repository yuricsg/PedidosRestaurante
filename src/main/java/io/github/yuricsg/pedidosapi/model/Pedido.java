package io.github.yuricsg.pedidosapi.model;

import jakarta.persistence.*;



@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double valor;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public Pedido() {
    }

    public Pedido(Long id, Double valor, Cliente cliente, StatusPedido status) {
        this.id = id;
        this.valor = valor;
        this.cliente = cliente;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
