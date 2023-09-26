package com.banco.api.domain.transacao;

import com.banco.api.domain.conta.Conta;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "transacoes")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    @ManyToOne
    private Conta pagador;
    @ManyToOne
    private Conta beneficiario;
    private LocalDateTime data_hora;

    public Transacao(BigDecimal valor, Conta pagador, Conta beneficiario) {
        this.valor = valor;
        this.pagador = pagador;
        this.beneficiario = beneficiario;
        this.data_hora = LocalDateTime.now();
    }

    public Transacao(BigDecimal valor, Conta conta) {
        this.valor = valor;
        this.pagador = conta;
        this.data_hora = LocalDateTime.now();
    }
}
