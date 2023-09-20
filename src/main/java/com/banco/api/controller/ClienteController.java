package com.banco.api.controller;

import com.banco.api.domain.cliente.Cliente;
import com.banco.api.dto.ClienteDTO;
import com.banco.api.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody ClienteDTO dados){
        repository.save(new Cliente(dados));
    }
}
