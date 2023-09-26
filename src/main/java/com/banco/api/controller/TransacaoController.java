package com.banco.api.controller;

import com.banco.api.domain.transacao.Transacao;
import com.banco.api.dto.DebitarDTO;
import com.banco.api.dto.DepositarDTO;
import com.banco.api.dto.TransacaoDTO;
import com.banco.api.repository.ContaRepository;
import com.banco.api.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static com.banco.api.domain.conta.TipoConta.EMPRESARIAL;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private ContaRepository repository;
    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping
    public ResponseEntity<TransacaoDTO> exibir(@RequestBody TransacaoDTO dados) {
        return ResponseEntity.ok(dados);
    }

    @Transactional
    @PostMapping("/depositar")
    public void depositar(@RequestBody DepositarDTO dados) {
        var conta = repository.getReferenceById(dados.id());
        conta.setSaldo(conta.getSaldo().add(dados.valor()));
        transacaoRepository.save(new Transacao(dados.valor(), conta));
    }

    @Transactional
    @PostMapping("/debitar")
    public void debitar(@RequestBody DebitarDTO dados) {
        var conta = repository.getReferenceById(dados.id());
        if ((dados.valor().compareTo(BigDecimal.ZERO) > 0) && (conta.getSaldo().compareTo(BigDecimal.ZERO) > 0)) {
            conta.setSaldo(conta.getSaldo().subtract(dados.valor()));
            transacaoRepository.save(new Transacao(dados.valor(), conta));
        }
    }

    @Transactional
    @PostMapping("/transferir")
    public void transferir(@RequestBody TransacaoDTO dados){
        var pagador = repository.getReferenceById(dados.pagador());
        var beneficiario = repository.getReferenceById(dados.beneficiario());


        if ((pagador.getSaldo().compareTo(dados.valor()) > 0) && !(pagador.getTipo() == EMPRESARIAL)) {
            pagador.setSaldo(pagador.getSaldo().subtract(dados.valor()));
            beneficiario.setSaldo(beneficiario.getSaldo().add(dados.valor()));
            System.out.println("Transação concluida.");
            System.out.println(dados.valor());
            System.out.println(pagador.getId());
            System.out.println(beneficiario);
            transacaoRepository.save(new Transacao(dados.valor(), pagador, beneficiario));
        }
    }
}
