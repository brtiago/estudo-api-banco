package com.banco.api.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record TransacaoDTO(
        @NotBlank
        BigDecimal valor,
        @NotBlank
        Long pagador,
        @NotBlank
        Long beneficiario
) {


}
