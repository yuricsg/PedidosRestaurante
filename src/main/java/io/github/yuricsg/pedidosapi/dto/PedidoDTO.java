package io.github.yuricsg.pedidosapi.dto;

import io.github.yuricsg.pedidosapi.model.StatusPedido;
import jakarta.validation.constraints.NotNull;

public record PedidoDTO(
        @NotNull(message = "campo obrigatório")
        Double valor,
        @NotNull(message = "campo obrigatório")
        Long clienteId,
        @NotNull(message = "campo obrigatório")
        StatusPedido status) {
}
