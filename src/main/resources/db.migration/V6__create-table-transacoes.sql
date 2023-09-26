create table transacoes(
    id bigint not null generated always as identity,
    valor numeric(38, 2),
    pagador_id bigint not null,
    beneficiario_id bigint,
    data_hora timestamp,

    PRIMARY KEY (id),

    CONSTRAINT fk_conta_pagador
    FOREIGN KEY (pagador_id)
    REFERENCES contas(id),

    CONSTRAINT fk_conta_beneficiario
        FOREIGN KEY (beneficiario_id)
            REFERENCES contas(id)

);