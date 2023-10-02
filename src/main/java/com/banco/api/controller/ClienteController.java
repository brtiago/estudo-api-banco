package com.banco.api.controller;

import com.banco.api.domain.cliente.Cliente;
import com.banco.api.dto.AtualizacaoClienteDTO;
import com.banco.api.dto.ClienteDTO;
import com.banco.api.dto.DadosDetalhamentoClienteDTO;
import com.banco.api.dto.ListagemClienteDTO;
import com.banco.api.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @Transactional
    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody @Valid ClienteDTO dados, UriComponentsBuilder uriBuilder) {
        var cliente = new Cliente(dados);
        repository.save(cliente);

        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoClienteDTO(cliente));
    }
    @GetMapping("/listar")
    public ResponseEntity<Page<ListagemClienteDTO>> listar(Pageable paginacao){
        var page = repository.findAll(paginacao).map(ListagemClienteDTO::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity atualizar(@RequestBody @Valid AtualizacaoClienteDTO dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoClienteDTO(cliente));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoClienteDTO(cliente));
    }

}
