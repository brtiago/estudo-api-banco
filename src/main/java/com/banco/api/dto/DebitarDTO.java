package com.banco.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DebitarDTO(
        @NotNull
        Long id,
        @NotBlank
        BigDecimal valor
) {
}
