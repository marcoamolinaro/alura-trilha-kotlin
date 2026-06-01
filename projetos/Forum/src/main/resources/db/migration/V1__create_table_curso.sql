create table cursos (
    id bigint not null auto_increment,
    nome varchar(50) not null,
    categoria varchar(50) not null,
    primary key(id)
);

insert into cursos values(1, 'Kotlin', 'Programacao');
insert into cursos values(2, 'HTML', 'Front-end');
