package com.banco.api.dto;

import com.banco.api.domain.conta.TipoConta;
import jakarta.validation.constraints.NotNull;

public record ContaDTO(
        @NotNull
        Long idCliente,
        @NotNull
        TipoConta tipo
) {}
