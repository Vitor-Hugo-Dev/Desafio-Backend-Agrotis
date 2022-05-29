INSERT INTO tb_laboratorio(name) VALUES ('Agro Skynet');
INSERT INTO tb_laboratorio(name) VALUES ('Umbrella Agro');
INSERT INTO tb_laboratorio(name) VALUES ('Osborn Agro');
INSERT INTO tb_laboratorio(name) VALUES ('Skyrim Agro');
INSERT INTO tb_laboratorio(name) VALUES ('Agro Brasil');

INSERT INTO tb_propriedade(name, cnpj) VALUES ('Agrotis 1', '04.909.987/0001-89');
INSERT INTO tb_propriedade(name, cnpj) VALUES ('Agrotis 2', '04.909.987/0001-88');
INSERT INTO tb_propriedade(name, cnpj) VALUES ('Agrotis 3', '04.909.987/0001-87');
INSERT INTO tb_propriedade(name, cnpj) VALUES ('Agrotis 4', '04.909.987/0001-86');
INSERT INTO tb_propriedade(name, cnpj) VALUES ('Agrotis 5', '04.909.987/0001-85');
INSERT INTO tb_propriedade(name, cnpj) VALUES ('Agrotis 6', '04.909.987/0001-84');

INSERT INTO tb_servico(description, initial_date, final_date, laboratorio_id, propriedade_id, usuario) VALUES ('serviço 1', '2022-02-02T17:41:44Z', '2022-02-02T17:41:44Z', 1, 1, 'John Connor');
INSERT INTO tb_servico(description, initial_date, final_date, laboratorio_id, propriedade_id, usuario) VALUES ('serviço 2', '2022-02-02T17:41:44Z', '2022-02-02T17:41:44Z', 2, 2, 'Leon Scott Kennedy');
INSERT INTO tb_servico(description, initial_date, final_date, laboratorio_id, propriedade_id, usuario) VALUES ('serviço 3', '2022-02-02T17:41:44Z', '2022-02-02T17:41:44Z', 4, 4, 'DragonBorn Agricultor');
