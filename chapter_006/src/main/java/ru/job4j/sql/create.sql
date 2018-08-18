CREATE DATABASE items_db;

CREATE TABLE state (
  state_id integer PRIMARY KEY,
  state character varying
);

insert into state values (1, 'enable');
insert into state values(2, 'disable');

CREATE TABLE roles (
  role_id integer PRIMARY KEY,
  role character varying
);

insert into roles values(1, 'admin');
insert into roles values(2, 'user');
insert into roles values(3, 'moderator');

CREATE TABLE attachs(
  attach_file_id serial PRIMARY KEY,
  file character varying
);

insert into attachs values (1, 'file1');
insert into attachs  values(2, 'file2');
insert into attachs  values(3, 'file3');

CREATE TABLE comments(
  comment_id serial PRIMARY KEY,
  comment varchar(300)
);

insert into comments  values(1, 'good');
insert into comments  values(2, 'bad');
insert into comments  values(3, 'excellent');

CREATE TABLE cathegory(
  cathegory_id serial PRIMARY KEY,
  cathegory character varying
);

insert into cathegory  values(1, 'books');
insert into cathegory  values(2, 'toys');
insert into cathegory  values(3, 'balls');
insert into cathegory  values(4, 'pens');

CREATE TABLE rules
(
  rule_id serial PRIMARY KEY,
  rule character varying
);

insert into rules  values(1, 'access1');
insert into rules  values(2, 'access2');
insert into rules  values(3, 'access3');

CREATE TABLE rules_roles(
  rules_id integer references rules(rules_id),
  roles_id integer references roles(role_id)
);

insert into rules_roles values(1, 1);
insert into rules_roles values(2, 2);
insert into rules_roles values(3, 3);

CREATE TABLE items(
  item_id integer PRIMARY KEY,
  item varchar(50),
  comment_id integer references comments(comment_id),
  state_id integer references state(state_id),
  cathegory_id integer references cathegory(cathegory_id),
  attachs_id integer references attachs(attach_file_id)
);

insert into items  values (1, 'red ball', 1, 1, 3, 1);
insert into items values (2, 'Harry Potter', 3, 2, 1, 3);

CREATE TABLE users(
  user_id integer PRIMARY KEY,
  item_id integer references items(item_id),
  last_name VARCHAR(50),
  last_name VARCHAR(50) ,
  email VARCHAR(30),
  password VARCHAR(30),
  role_id references roles(role_id)
);

insert into users values (1, 1, 'Ivan', 'Vazovskiy', 'ivan@mail.ru', 'password', 2);
insert into users values (2, 2, 'Irina', 'Kim', 'irina@mail.ru', 'password', 2);