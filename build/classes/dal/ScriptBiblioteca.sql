create database biblioteca;

use biblioteca;

create table genero(
    id_genero int auto_increment primary key,
    descricao_genero varchar(50)
);

insert into genero
value(default,"Terror"),(default,"Suspense"),(default,"Romance"),(default,"Comédia"),(default,"Ação"),(default,"Ficção");

create table livro(
    id_livro int auto_increment primary key,
    nome_livro varchar(50),
    paginas int,
    nota int,
    dataRegistro date,
    id_genero int
);

alter table livro
add constraint fkGeneroIdGenero foreign key (id_genero) references genero(id_genero);

create table marcacoes(
    id_marcacao int auto_increment primary key,
    pagina_atual int,
    anotacao varchar(200),
    id_livro int,
    FOREIGN KEY (id_livro) REFERENCES livros(id_livro)
);

SELECT * FROM livro l 
INNER JOIN genero g ON l.id_genero = g.id_genero;
