create table usuarios (
    id bigint not null auto_increment,
    nome varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into usuarios values(1, 'Ana da Silva', 'ana@email.com');