package io.github.yuricsg.pedidosapi.dto;

import io.github.yuricsg.pedidosapi.model.StatusPedido;

public record PedidoDTO(Double valor, Long clienteId, StatusPedido status) {
}
