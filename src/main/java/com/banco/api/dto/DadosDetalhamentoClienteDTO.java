package com.banco.api.dto;

import com.banco.api.domain.cliente.Cliente;

public record DadosDetalhamentoClienteDTO(String nome, String documento, String email) {
    public DadosDetalhamentoClienteDTO(Cliente cliente){
        this(cliente.getNome(), cliente.getDocumento(), cliente.getEmail());
    }
}
