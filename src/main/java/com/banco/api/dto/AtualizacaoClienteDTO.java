package com.banco.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoClienteDTO(
        @NotNull
        Long id,
        String nome,
        @Email
        String email,
        String senha) {
}