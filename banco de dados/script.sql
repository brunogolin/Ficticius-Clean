
DROP TABLE VEICULO
GO

CREATE TABLE VEICULO
	(
	veiculoId             NUMERIC (010) NOT NULL IDENTITY,
	nome                  VARCHAR (100) NOT NULL,
	marca                 VARCHAR (050) NOT NULL,
	modelo                VARCHAR (100) NOT NULL,
	ano_fabricacao        NUMERIC (004) DEFAULT 0 NOT NULL,
	consumo_medio_cidade  NUMERIC (5,2) NOT NULL,
	consumo_medio_rodovia NUMERIC (5,2) NOT NULL
	CONSTRAINT XPKVEICULO PRIMARY KEY (veiculoId)
	)
GO
