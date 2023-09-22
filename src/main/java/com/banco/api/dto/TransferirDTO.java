package com.banco.api.dto;

import com.banco.api.domain.conta.Conta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransferirDTO(
        @NotBlank
        BigDecimal valor,
        @NotBlank
        Long idContaPagador,
        @NotEmpty
        String tipoPagador,
        @NotBlank
        Long idContaBeneficiario,
        @NotEmpty
        String tipoBeneficiario,
        @NotEmpty
        LocalDateTime timestamp
){
}
