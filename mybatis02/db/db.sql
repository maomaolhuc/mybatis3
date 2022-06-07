create table user(
	id int not null auto_increment,
	name varchar(32) not null,
	password varchar(32) not null,
	age int not null,
	create_time datetime null,
	primary key(id)
);