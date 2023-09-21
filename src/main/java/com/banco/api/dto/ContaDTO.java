package com.banco.api.dto;

import com.banco.api.domain.conta.Conta;
import com.banco.api.domain.conta.TipoConta;
import jakarta.validation.constraints.NotNull;

public record ContaDTO(
        @NotNull
        Long idCliente,
        @NotNull
        TipoConta tipo
) {
        public ContaDTO (Conta conta){
                this(conta.getIdCliente(), conta.getTipo());
        }
}
