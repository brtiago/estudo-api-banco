package com.banco.api.controller;

import com.banco.api.domain.transacao.Transacao;
import com.banco.api.dto.TransacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransacaoController {
    @PostMapping
    public ResponseEntity<TransacaoDTO> exibir(@RequestBody TransacaoDTO dados) {
        return ResponseEntity.ok(dados);
    }
}
