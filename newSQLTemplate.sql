/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  patyf
 * Created: 28 de jun de 2021
 */

create database exemplobd;
use exemplobd;

create table cadastro(
id integer not null auto_increment,
nome varchar (100) not null,
cnpj_cpf varchar(100), not nul
data_nascimento date, 
data_cadastro datetime,
constraint pk_pessoa primary key(id)
);

insert into cadastro (nome, data_nascimento, data_cadastro) values
( 'Fulano da Silva', '2000-05-18', now());
select * from pessoa;
