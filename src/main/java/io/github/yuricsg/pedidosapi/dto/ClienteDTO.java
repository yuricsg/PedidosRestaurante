package io.github.yuricsg.pedidosapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteDTO(
        @NotBlank(message = "campo obrigatório")
        @Size(min = 2, max = 100, message = "fora do tamanho padrão")
        String nome,
        @NotBlank(message = "campo obrigatório")
        @Email(message = "e-mail inválido")
        String email) {
}
