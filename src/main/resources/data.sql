-- PROFESSORES --
INSERT INTO tb_professores (id, avaliacao, email, nome)
SELECT 1, 5.0, 'teste@gmail.com', 'Thiago Faleiros'
FROM (SELECT 1) AS tmp
WHERE NOT EXISTS (
        SELECT nome FROM tb_professores WHERE nome = 'Thiago Faleiros'
    ) LIMIT 1;

INSERT INTO tb_professores (id, avaliacao, email, nome)
SELECT 2, 5.0, 'teste@gmail.com', 'Jorge Lucero'
FROM (SELECT 1) AS tmp
WHERE NOT EXISTS (
        SELECT nome FROM tb_professores WHERE nome = 'Jorge Lucero'
    ) LIMIT 1;

INSERT INTO tb_professores (id, avaliacao, email, nome)
SELECT 3, 5.0, 'teste@gmail.com', 'Daniel Porto'
FROM (SELECT 1) AS tmp
WHERE NOT EXISTS (
        SELECT nome FROM tb_professores WHERE nome = 'Daniel Porto'
    ) LIMIT 1;

INSERT INTO tb_professores (id, avaliacao, email, nome)
SELECT 4, 5.0, 'teste@gmail.com', 'Marcus Lamar'
FROM (SELECT 1) AS tmp
WHERE NOT EXISTS (
        SELECT nome FROM tb_professores WHERE nome = 'Marcus Lamar'
    ) LIMIT 1;

INSERT INTO tb_professores (id, avaliacao, email, nome)
SELECT 5, 5.0, 'teste@gmail.com', 'Fernando Chacon'
FROM (SELECT 1) AS tmp
WHERE NOT EXISTS (
        SELECT nome FROM tb_professores WHERE nome = 'Fernando Chacon'
    ) LIMIT 1;

-- DISCIPLINAS --

INSERT INTO tb_disciplinas (codigo, nome, ementa, avaliacao)
SELECT 'CIC0002', 'Fundamentos Teóricos da Computação', 'Ementa de Fundamentos Teóricos da Computação', 5.0
FROM (SELECT 1) AS tmp
WHERE NOT EXISTS (
        SELECT codigo FROM tb_disciplinas WHERE codigo = 'CIC0002'
    ) LIMIT 1;

INSERT INTO tb_disciplinas (codigo, nome, ementa, avaliacao)
SELECT 'CIC0003', 'Introdução aos Sistemas Computacionais', 'Ementa de Introdução aos Sistemas Computacionais', 5.0
FROM (SELECT 1) AS tmp
WHERE NOT EXISTS (
        SELECT codigo FROM tb_disciplinas WHERE codigo = 'CIC0003'
    ) LIMIT 1;

INSERT INTO tb_disciplinas (codigo, nome, ementa, avaliacao)
SELECT 'CIC0004', 'Algoritmos e Programação de Computadores', 'Ementa de Algoritmos e Programação de Computadores', 5.0
FROM (SELECT 1) AS tmp
WHERE NOT EXISTS (
        SELECT codigo FROM tb_disciplinas WHERE codigo = 'CIC0004'
    ) LIMIT 1;

INSERT INTO tb_disciplinas (codigo, nome, ementa, avaliacao)
SELECT 'CIC0005', 'Formação Docente em Computação', 'Ementa de Formação Docente em Computação', 5.0
FROM (SELECT 1) AS tmp
WHERE NOT EXISTS (
        SELECT codigo FROM tb_disciplinas WHERE codigo = 'CIC0005'
    ) LIMIT 1;

INSERT INTO tb_disciplinas (codigo, nome, ementa, avaliacao)
SELECT 'CIC0007', 'Introdução à Ciência da Computação', 'Ementa de Introdução à Ciência da Computação', 5.0
FROM (SELECT 1) AS tmp
WHERE NOT EXISTS (
        SELECT codigo FROM tb_disciplinas WHERE codigo = 'CIC0007'
    ) LIMIT 1;