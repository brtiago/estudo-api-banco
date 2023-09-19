package com.banco.api.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record TransacaoDTO(
        @NotBlank
        BigDecimal valor,
        @NotBlank
        Long contaDebitada,
        @NotBlank
        Long contaCreditada
) {


}
