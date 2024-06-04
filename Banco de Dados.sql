create database trabalho2;
use trabalho2;

create table cliente(
	cpf bigint primary key not null,
    nome varchar(30) not null,
    email varchar(30) not null,
    dataNascimento date
);

create table produto(
	codigo int primary key not null auto_increment,
    nome varchar(50) not null,
    descricao varchar(100),
    precoCusto double not null,
    precoVenda double not null,
    quantidade int not null,
    categoria varchar(30) not null
);

create table pagamento(
	codigo int primary key not null auto_increment,
    tipo varchar(30) not null,
    valorPago double not null
);

create table venda(
	codigo int primary key not null auto_increment,
    produtoId int not null,
    foreign key(produtoId) references produto(codigo),
    clienteId bigint not null,
    foreign key(clienteId) references cliente(cpf),
    pagamentoId int not null,
    foreign key(pagamentoId) references pagamento(codigo),
    dataVenda date,
    valorTotal double not null
);