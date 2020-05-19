drop table if exists reservations;
drop table if exists canland;
drop table if exists fares;
drop table if exists leginstances;
drop table if exists legs;
drop table if exists airplanes;
drop table if exists planetypes;
drop table if exists flights;
drop table if exists airports;
drop table if exists views;
drop procedure if exists flightHistory;

create table airports(
acode char(3),
name varchar(50),
city varchar(15),
state varchar(15),
primary key (acode))
engine = innodb;

create table flights(
fnum varchar(7),
airline varchar(15),
weekdays varchar(7),
primary key(fnum))
engine = innodb;

create table planetypes(
typename varchar(15),
maxseats int not null,
company varchar(15),
primary key(typename))
engine = innodb;

create table airplanes(
airplaneid varchar(5),
totalseats int not null,
typename varchar(15),
primary key(airplaneid),
foreign key(typename) references planetypes(typename))
engine = innodb;

create table legs(
fnum varchar(7),
lnum varchar(2),
departcode char(3),
departtime time,
arrivalcode char(3),
arrivaltime time,
primary key(fnum, lnum),
foreign key(fnum) references flights(fnum) on delete cascade,
foreign key(departcode) references airports(acode) on delete cascade,
foreign key(arrivalcode) references airports(acode) on delete cascade)
engine = innodb;

create table leginstances(
fnum varchar(7),
lnum varchar(2),
ldate date,
availseats int not null,
airplaneid varchar(5),
departcode char(3),
departtime time,
arrivalcode char(3),
arrivaltime time,
status time default '00:00:00',
primary key(fnum,lnum,ldate),
foreign key(fnum,lnum) references legs(fnum,lnum) on delete cascade,
foreign key(departcode) references airports(acode) on delete cascade,
foreign key(arrivalcode) references airports(acode) on delete cascade,
foreign key(airplaneid) references airplanes(airplaneid) on delete set null)
engine =innodb;

create table fares(
fnum varchar(7),
farecode varchar(8),
amount float(6,2),
restrictions varchar(15),
primary key (fnum,farecode),
foreign key(fnum) references flights(fnum) on delete cascade)
engine =innodb;

create table canland(
typename varchar(15),
acode char(3),
primary key(typename,acode),
foreign key(acode) references airports(acode) on delete cascade,
foreign key(typename) references planetypes(typename))
engine = innodb;

create table reservations(
fnum varchar(7),
lnum varchar(2),
date date,
seatnum varchar(3),
customername varchar(15),
customerphone varchar(15),
primary key(fnum,lnum,date,seatnum),
foreign key(fnum,lnum,date) references leginstances(fnum,lnum,ldate) on delete cascade)
engine = innodb;

create table views(
username varchar(15),
password varchar(32),
jobtitle varchar(15),
view varchar(10),
primary key(username))
engine = innodb;

delimiter //
create procedure flightHistory( in flightnumber varchar(7), in legnumber varchar(2), 
out average float) begin select avg(status)/100 into average from leginstances where 
fnum = flightnumber and lnum = legnumber ; end// 
delimiter ;
