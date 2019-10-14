Create database Cinema;

use Cinema;

CREATE TABLE IF NOT EXISTS Filmes (
	FilmeID INT NOT NULL auto_increment,
	Titulo VARCHAR(126) NOT NULL,
	Diretor VARCHAR(126) NOT NULL,
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
	Ingressos INT NOT NULL,
	Data DateTime NOT NULL,
	ValorIngresso Numeric(5,2) NOT NULL,
    
	PRIMARY KEY (SessaoID),
    FOREIGN KEY fk_filme(FilmeID)
	   REFERENCES Filmes(FilmeID)
	   ON UPDATE RESTRICT
	   ON DELETE RESTRICT,
	FOREIGN KEY fk_sala(SalaID)
	   REFERENCES Salas(SalaID)
	   ON UPDATE RESTRICT
	   ON DELETE RESTRICT
);