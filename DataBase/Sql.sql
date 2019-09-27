use master;
create database Cinema;

use Cinema;

create table Filme (
    Varchar(252) titulo;
    Varchar(126) diretor;
    Varchar(50) genero;
    Varchar(50) idioma;
    Integer duracao;
);

create table Sala (
    Integer Numero;
    Integer Capacidade;
);

create table Sessao (
    Date Data;
    Numeric(5,2) ValorIngresso;
    Integer IngressoDisponivel;
);
