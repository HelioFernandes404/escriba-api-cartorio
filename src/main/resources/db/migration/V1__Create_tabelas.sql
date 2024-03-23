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

CREATE TABLE tb_cartorios (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              nome VARCHAR(150) NOT NULL,
                              observacao VARCHAR(250),
                              situacao_id INT,
                              FOREIGN KEY (situacao_id) REFERENCES tb_situacao_cartorio(id)
);

CREATE TABLE tb_atribuicao_cartorio (
                                        atribuicao_cartorio_id INT,
                                        atribuicoes_id INT,
                                        PRIMARY KEY (atribuicao_cartorio_id, atribuicoes_id),
                                        FOREIGN KEY (atribuicao_cartorio_id) REFERENCES tb_cartorios(id),
                                        FOREIGN KEY (atribuicoes_id) REFERENCES tb_atribuicao(id)
);