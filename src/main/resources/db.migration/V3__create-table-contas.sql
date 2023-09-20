CREATE TABLE contas (
    id bigint not null,
    cliente_id bigint not null,
    saldo numeric(38, 2),
    ativo boolean not null,
    tipo varchar(20) not null,
    PRIMARY KEY (id),
    CONSTRAINT fk_conta_cliente
    FOREIGN KEY (cliente_id)
    REFERENCES clientes(id)
);
