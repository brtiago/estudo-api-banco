package com.banco.api.domain.cliente;

import com.banco.api.dto.ClienteDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "clientes")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String documento;
    @Column(unique = true)
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private TipoCliente tipo;

    public Cliente(ClienteDTO dados) {
        this.nome = dados.nome();
        this.documento = dados.documento();
        this.email = dados.email();
        this.senha = dados.senha();
        this.tipo = dados.tipo();
    }
}
