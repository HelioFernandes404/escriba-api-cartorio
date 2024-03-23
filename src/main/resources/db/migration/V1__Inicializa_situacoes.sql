CREATE TABLE
    tb_situacaos (id VARCHAR(20) PRIMARY KEY, nome VARCHAR(50));

-- Inserir a situação "Ativo"
INSERT INTO
    tb_situacaos (id, nome)
VALUES
    ('SIT_ATIVO', 'Ativo');

-- Inserir a situação "Bloqueado"
INSERT INTO
    tb_situacaos (id, nome)
VALUES
    ('SIT_BLOQUEADO', 'Bloqueado');