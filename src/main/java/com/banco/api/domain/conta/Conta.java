package com.banco.api.domain.conta;

import com.banco.api.dto.ContaDTO;
import com.banco.api.dto.DepositarDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "contas")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cliente_id")
    private Long idCliente;
    private BigDecimal saldo;
    @Enumerated(EnumType.STRING)
    private TipoConta tipo;
    private Boolean ativo;
    public Conta(ContaDTO dados) {
        this.idCliente = dados.idCliente();
        this.saldo = BigDecimal.ZERO;
        this.tipo = dados.tipo();
        this.ativo =true;
    }

    public void excluir() {
        this.ativo = false;
    }

    public BigDecimal depositar(DepositarDTO dados) {
        var valor = dados.valor();
        if (valor.compareTo(BigDecimal.ZERO) >= 0){
            this.saldo = this.saldo.add(valor);
        }
        return this.saldo;
    }

    public BigDecimal debitar(DepositarDTO dados) {
        var valor = dados.valor();
        if ((valor.compareTo(BigDecimal.ZERO) > 0) && (this.saldo.compareTo(BigDecimal.ZERO) > 0)) {
            this.saldo = this.saldo.subtract(valor);
        }
        return this.saldo;
    }
}
