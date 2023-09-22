package com.banco.api.controller;

import com.banco.api.domain.transacao.Transacao;
import com.banco.api.dto.DebitarDTO;
import com.banco.api.dto.DepositarDTO;
import com.banco.api.dto.TransacaoDTO;
import com.banco.api.dto.TransferirDTO;
import com.banco.api.repository.ContaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private ContaRepository repository;

    @PostMapping
    public ResponseEntity<TransacaoDTO> exibir(@RequestBody TransacaoDTO dados) {
        return ResponseEntity.ok(dados);
    }

    @Transactional
    @PostMapping("/depositar")
    public BigDecimal depositar(@RequestBody DepositarDTO dados) {
        var conta = repository.getReferenceById(dados.id());
        if (dados.valor().compareTo(BigDecimal.ZERO) >= 0){
            conta.setSaldo(conta.getSaldo().add(dados.valor()));
        }
            return conta.getSaldo();
    }

    @Transactional
    @PostMapping("/debitar")
    public BigDecimal debitar(@RequestBody DebitarDTO dados) {
        var conta = repository.getReferenceById(dados.id());
        if ((dados.valor().compareTo(BigDecimal.ZERO) > 0) && (conta.getSaldo().compareTo(BigDecimal.ZERO) > 0)) {
            conta.setSaldo(conta.getSaldo().subtract(dados.valor()));
        }
        return conta.getSaldo();
    }


/*
    @Transactional
    @PostMapping("/transferir")
    public void transferir (@RequestBody TransferirDTO dados) {
        var pagador = repository.getReferenceById(dados.idContaPagador());
        var beneficiario = repository.getReferenceById(dados.idContaBeneficiario());
        var timestamp = dados.timestamp();

        if ((!"EMPRESARIAL".equals(pagador.getTipo())) && (pagador.getSaldo().compareTo(dados.valor()) > 0)){
            pagador.setSaldo(pagador.debitar(dados.valor()));
            beneficiario.setSaldo(beneficiario.depositar(dados.valor()));
        }
    }
*/
}
