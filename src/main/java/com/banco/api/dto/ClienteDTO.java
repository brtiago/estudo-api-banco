package com.banco.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteDTO(
        @NotBlank
        String nome,
        @NotBlank
        String documento,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha) {
}
