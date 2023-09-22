package com.banco.api.controller;

import com.banco.api.domain.conta.Conta;
import com.banco.api.dto.ContaDTO;
import com.banco.api.dto.DepositarDTO;
import com.banco.api.dto.DebitarDTO;
import com.banco.api.repository.ContaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaRepository repository;

    @Transactional
    @PostMapping
    public void cadastrar(@RequestBody ContaDTO contaDto){
        repository.save(new Conta(contaDto));
    }

    @GetMapping
    public List<ContaDTO> listar() {
        // return repository.findAll().stream().map(conta -> new ContaDTO(conta.getIdCliente(), conta.getTipo())).toList();
        return repository.findAll().stream().map(ContaDTO::new).toList();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        var conta = repository.getReferenceById(id);
        conta.excluir();
    }

}
