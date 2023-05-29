set foreign_key_checks = 0;

delete from grupo;
delete from grupo_permissao;
delete from permissao;
delete from usuario;
delete from curso;
delete from usuario_grupo;
delete from usuario_curso;

set foreign_key_checks = 1;


ALTER TABLE grupo auto_increment = 1;
ALTER TABLE permissao auto_increment = 1;
ALTER TABLE usuario auto_increment = 1;;
ALTER TABLE curso auto_increment = 1;


insert into permissao (id, nome, descricao) values (1, 'EDITAR_CURSO', 'Permite cadastro e edição de curso'); 
insert into permissao (id, nome, descricao) values (2, 'LANCAR_CURSO', 'Permite lançamento de cursos');

insert into grupo (id, nome) values (1, 'ALUNO'), (2, 'EMPRESARIO');

insert into grupo_permissao (grupo_id, permissao_id) values (1, 1), (1, 2), (2, 1), (2, 2); 

insert into usuario (id, cpf, nome, email, senha, data_nascimento, genero, telefone, nome_empresa, data_cadastro) values
(1, '999.9999.999-99','João da Silva', 'joao@bosque.com.br', '$2a$12$OLbbe0EYWAhh0XlDNek1cuwUvKqgyYcYrvFecBZbq8B0lT7Rzatqy', '1993-12-23','MASCULINO', '95215648', 'Bosque', current_timestamp),
(2, '999.9999.999-97', 'Rodrigo Lima', 'rodrigo@bosque.com.br', '$2a$12$OLbbe0EYWAhh0XlDNek1cuwUvKqgyYcYrvFecBZbq8B0lT7Rzatqy', '1995-05-12','MASCULINO', '95215648', 'Bosque', current_timestamp),
(3, '999.9999.999-98','Maria Joaquina', 'maria@bosque.com.br', '$2a$12$OLbbe0EYWAhh0XlDNek1cuwUvKqgyYcYrvFecBZbq8B0lT7Rzatqy', '1970-01-17','FEMININO', '95215648', 'Bosque', current_timestamp);

insert into curso (id, nome) values (1,  'Java');
insert into curso (id, nome) values (2,  'Kotlin');
insert into curso (id, nome) values (3, 'Javascript');

insert into usuario_curso (usuario_id, curso_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 1), (3, 2);

insert into usuario_grupo (usuario_id, grupo_id) values (1, 1), (2, 1), (3, 1);

