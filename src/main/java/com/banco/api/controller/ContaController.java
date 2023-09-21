package com.banco.api.controller;

import com.banco.api.domain.conta.Conta;
import com.banco.api.dto.ContaDTO;
import com.banco.api.repository.ContaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaRepository repository;

    @Transactional
    @PostMapping("/cadastrar/")
    public void cadastrar(@RequestBody ContaDTO contaDto){
        repository.save(new Conta(contaDto));
    }
}
