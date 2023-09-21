package com.banco.api.controller;

import com.banco.api.domain.cliente.Cliente;
import com.banco.api.dto.AtualizacaoClienteDTO;
import com.banco.api.dto.ClienteDTO;
import com.banco.api.dto.ListagemClienteDTO;
import com.banco.api.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @Transactional
    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody @Valid ClienteDTO dados) {
        repository.save(new Cliente(dados));
    }
    @GetMapping("/listar")
    public Page<ListagemClienteDTO> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(ListagemClienteDTO::new);
    }

    @Transactional
    @PutMapping("/{id}")
    public void atualizar(@RequestBody @Valid AtualizacaoClienteDTO dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluir();
    }

}
