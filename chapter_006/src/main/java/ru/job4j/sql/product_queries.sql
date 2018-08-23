--product(id, name, type_id, expired_date, price)

--type(id, name)
create table product (
  id serial primary key,
  name varchar(50),
  type_id integer references type(id),
  expired_date timestamp,
  prict integer
);
insert into product values (1, 'Гауда', 1, '2018-09-08 04:05:05', 200);
insert into product values (2, 'Котлета', 2, '2018-07-08 04:05:05', 200);
insert into product values (3, 'Лук', 4, '2018-09-15 04:05:05', 200);
insert into product values (4, 'Груши', 5, '2018-09-08 04:05:05', 50);
insert into product values (5, 'Моцарелла', 1, '2018-10-08 04:05:05', 300);
insert into product values (6, 'Мясо мороженное', 2, '2018-10-08 04:05:05', 350);
insert into product values (7, 'Му Му', 6, '2018-10-08 04:05:05', 56);

create table type (
  id serial primary key,
  name varchar(50)
);
insert into type values (1, 'СЫР');
insert into type values (2, 'МЯСО');
insert into type values (4, 'ОВОЩИ');
insert into type values (5, 'ФРУКТЫ');
insert into type values (6, 'МОЛОКО');


--1

select * from product
  inner join
  type
    on product.type_id = type.id
where type.name = 'СЫР';

--2

select * from product
where product.name like '%мороженное%';

--3
select * from product
where product.expired_date > '2018-09-01 00:00:00'
      and
      product.expired_date < '2018-10-01 00:00:00';

--4
select id, name, max(prict)
from product
group by id;
--5
select count(p.id) from product as p
  inner join
  type
    on p.type_id = type.id
where type.name = 'СЫР';
--6
select * from product
  inner join
  type
    on product.type_id = type.id
where type.name = 'СЫР'
      or
      type.name = 'МОЛОКО';
--7

select type.name, count(product.name)
from product
  inner join
  type
    on product.type_id = type.id
group by type.name
having count(product.name) < 10;
--8
select * from product
  inner join
  type
    on product.type_id = type.id;