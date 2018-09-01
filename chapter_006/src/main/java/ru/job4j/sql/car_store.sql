create table transmission (
  id serial primary key,
  name varchar(50)
);
insert into transmission values (1, 'suzuki_transmission');
insert into transmission values(2, 'nissan_transmission');
insert into transmission values(3, 'toyota_transmission');
insert into transmission values (4, 'hyundai_transmission');
insert into transmission values(5, 'renault_transmission');
insert into transmission values(6, 'honda_transmission');

create table engine (
  id serial primary key,
  name varchar(50)
);
insert into engine values (1, 'suzuki_engine');
insert into engine values(2, 'nissan_engine');
insert into engine values(3, 'toyota_engine');
insert into engine values (4, 'hyundai_engine');
insert into engine values(5, 'renault_engine');

create table car_body(
  id serial primary key,
  name varchar(50)
);

insert into car_body values (1, 'suzuki_car_body');
insert into car_body values(2, 'nissan_car_body');
insert into car_body values(3, 'toyota_car_body');
insert into car_body values (4, 'hyundai_car_body');

create table car (
  id serial primary key,
  name varchar(50),
  transmission_id integer references transmission(id),
  engine_id integer references engine(id),
  car_body_id integer references car_body(id)
);
insert into car values (1, 'suzuki', 1, 1, 1);
insert into car values(2, 'nissan', 2, 2, 2);
insert into car values(3, 'toyota', 3, 3, 3);

select car.name, transmission.name, engine.name, car_body.name
from car
  left outer join transmission
    on car.transmission_id = transmission.id
  left outer join engine
    on car.engine_id = engine.id
  left outer join car_body
    on car.car_body_id = car_body.id;



select t.name, car.name
from transmission t
  left outer join
  car
    on car.transmission_id = t.id
where car.id is null;

select e.name, car.name
from engine e
  left outer join
  car
    on car.engine_id = e.id
where car.id is null;

select cb.name, car.name
from car_body cb
  left outer join
  car
    on car.car_body_id = cb.id
where car.id is null;
