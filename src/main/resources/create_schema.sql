CREATE TABLE usuario (
	id serial primary key,
	nome varchar(35) not null,
	senha varchar(20) not null,
	caminhoImagem text not null
);

CREATE TABLE post (
	id serial primary key,
	mensagem text not null,
	usuario_id int,
	FOREIGN KEY (usuario_id) REFERENCES usuario (id) ON DELETE CASCADE ON UPDATE CASCADE
);
