Create database Cinema;

use Cinema;

CREATE TABLE IF NOT EXISTS Filmes (
	FilmeID INT NOT NULL auto_increment,
	Titulo VARCHAR(126) NULL,
	Diretor VARCHAR(126) NULL,
	Genero VARCHAR(126) NOT NULL,
	Idioma VARCHAR(126) NOT NULL,
	Duracao INT NOT NULL,
  
	PRIMARY KEY (FilmeID)
);

CREATE TABLE IF NOT EXISTS Salas (
	SalaID INT NOT NULL auto_increment,
    Numero INT NOT NULL,
	Capacidade INT NOT NULL,
    
	PRIMARY KEY (SalaID)
);

CREATE TABLE IF NOT EXISTS Sessoes (
	SessaoID INT NOT NULL auto_increment,
    FilmeID INT NOT NULL,
	SalaID INT NOT NULL,
	Ingressos VARCHAR(126) NULL,
	Data DateTime NOT NULL,
	ValorIngresso Numeric(5,2) NOT NULL
    
	PRIMARY KEY (SessaoID),
    FOREIGN KEY fk_filme(FilmeID)
	   REFERENCES Filme(FilmeID)
	   ON UPDATE RESTRICT
	   ON DELETE RESTRICT,
	FOREIGN KEY fk_sala(SalaID)
	   REFERENCES Sala(SalaID)
	   ON UPDATE RESTRICT
	   ON DELETE RESTRICT
);

INSERT INTO CategoriaConta(Descricao, Positiva) VALUES('Moradia',0);

INSERT INTO CategoriaConta(Descricao, Positiva) VALUES('Transporte',0);

INSERT INTO CategoriaConta(Descricao, Positiva) VALUES('Vestuario',0);

INSERT INTO CategoriaConta(Descricao, Positiva) VALUES('Lazer',0);

INSERT INTO CategoriaConta(Descricao, Positiva) VALUES('Emprego',1);

INSERT INTO CategoriaConta(Descricao, Positiva) VALUES('Investimento',1);

INSERT INTO CategoriaConta(Descricao, Positiva) VALUES('Freelancer',1);


Select * from CategoriaConta;


INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(1, 'Água');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(1, 'Energia');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(1, 'Gás');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(1, 'Condominio');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(1, 'Internet');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(2, 'Carro');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(2, 'Onibus');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(2, 'Bicicleta');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(3, 'Camisas');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(3, 'Sapatos');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(3, 'Blazers');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(3, 'Calças');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(4, 'Salário');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(4, 'Horas extras');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(4, 'bonus');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(5, 'Habitação');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(5, 'Bolsa de valores');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(5, 'Selic');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(6, 'Programação');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(6, 'Design');

INSERT INTO SubCategoria(CategoriaContaID, Descricao) VALUES(6, 'Consultoria');


Select * from Movimentacao;


INSERT INTO Movimentacao(SubCategoriaID, DataOcorrencia, Descricao, Valor, FormaPagamento) VALUES(1, '2019/03/06', 'mov001', 100, 4);

INSERT INTO Movimentacao(SubCategoriaID, DataOcorrencia, Descricao, Valor, FormaPagamento) VALUES(2, '2019/07/01', 'Mov002', 120, 2);

INSERT INTO Movimentacao(SubCategoriaID, DataOcorrencia, Descricao, Valor, FormaPagamento) VALUES(1, '2019/09/08', 'Mov003', 360, 1);

INSERT INTO Movimentacao(SubCategoriaID, DataOcorrencia, Descricao, Valor, FormaPagamento) VALUES(4, '2019/06/07', 'Mov004', 1475, 1);

INSERT INTO Movimentacao(SubCategoriaID, DataOcorrencia, Descricao, Valor, FormaPagamento) VALUES(7, '2019/07/15', 'Mov005', 22.35, 4);

INSERT INTO Movimentacao(SubCategoriaID, DataOcorrencia, Descricao, Valor, FormaPagamento) VALUES(3, '2019/04/22', 'Mov006', 295, 3);

INSERT INTO Movimentacao(SubCategoriaID, DataOcorrencia, Descricao, Valor, FormaPagamento) VALUES(6, '2019/08/11', 'Mov007', 785, 2);