create table curso (
	id bigint not null auto_increment,
	nome varchar(80) not null,
	
	primary key (id)
)engine=InnoDb default charset=utf8;

 
create table usuario_curso (
	usuario_id bigint not null,
	curso_id bigint not null,
	
	primary key (usuario_id, curso_id)
)engine=InnoDb default charset=utf8;