package com.banco.api.domain.conta;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idCliente;
    private BigDecimal saldo;
    @Enumerated
    private TipoConta tipo;

}
