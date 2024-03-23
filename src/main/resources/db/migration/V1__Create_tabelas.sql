CREATE TABLE tb_situacao_cartorio (
                                      id VARCHAR(20) NOT NULL,
                                      nome VARCHAR(50) NOT NULL,
                                      PRIMARY KEY (id)
);

CREATE TABLE tb_atribuicao_cartorio (
                                        id VARCHAR(20) NOT NULL,
                                        nome VARCHAR(50) NOT NULL,
                                        situacao BOOLEAN NOT NULL DEFAULT TRUE,
                                        PRIMARY KEY (id)
);
