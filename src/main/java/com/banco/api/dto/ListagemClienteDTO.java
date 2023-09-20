package com.banco.api.dto;

import com.banco.api.domain.cliente.Cliente;
import com.banco.api.domain.cliente.TipoCliente;

public record ListagemClienteDTO(String nome, String email, TipoCliente tipo) {
    public ListagemClienteDTO(Cliente cliente){
        this(cliente.getNome(), cliente.getEmail(), cliente.getTipo());
    }
}
