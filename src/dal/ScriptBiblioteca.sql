create database if not exists biblioteca;

use biblioteca;

create table generos(
    id_genero int auto_increment primary key,
    descricao_genero varchar(50)
);

insert into generos
value(default,"Terror"),(default,"Suspense"),(default,"Romance"),
    (default,"Comédia"),(default,"Ação"),(default,"Ficção"),(default,"Investimento"),
    (default,"Educação"),(default,"Desenvolvimento Pessoal"),(default,"Drama"),(default,"Artes");

create table livros(
    id_livro int auto_increment primary key,
    nome_livro varchar(50),
    paginas int,
    nota int,
    data_registro datetime default current_timestamp,
    data_editado datetime on update current_timestamp,
    lido boolean,
    id_genero int
);

create table marcacoes(
    id_marcacao int auto_increment primary key,
    id_livro int,
    pagina_atual int,
    titulo varchar(50),
    data_registro_marcacao datetime default current_timestamp,
    data_editado_marcacao datetime on update current_timestamp,
    anotacao varchar(200)    
);

alter table livros
add constraint fkGeneroIdGenero foreign key (id_genero) references generos (id_genero);
 
alter table marcacoes
add constraint fkLivroIdLivro foreign key (id_livro) references livros (id_livro);
