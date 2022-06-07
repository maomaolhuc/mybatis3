create database mybatis;

use mybatis;

create table student(
	id int not null auto_increment,
	name varchar(32) not null,
	age int not null,
	create_time datetime null,
	primary key(id)
);