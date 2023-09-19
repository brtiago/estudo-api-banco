create table cliente(
    id bigint not null generated always as identity,
    nome varchar(100) not null,
    documento varchar(20) not null unique,
    email varchar(100) not null unique,
    senha varchar(50) not null,
    tipo varchar(20) not null,

    primary key(id)
);