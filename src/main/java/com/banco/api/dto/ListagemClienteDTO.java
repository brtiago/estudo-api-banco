package com.banco.api.dto;

import com.banco.api.domain.cliente.Cliente;

public record ListagemClienteDTO(Long id, String nome, String email) {
    public ListagemClienteDTO(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }
}
