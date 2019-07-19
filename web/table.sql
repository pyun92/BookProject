create table member2(
	userid varchar(8) not null primary key,
	userpwd varchar(10) not null
);

select * from member2;

insert into member2 values('candy','1234');
insert into member2 values('admin','5678');
show tables;

select * from bookshop
create table bookshop(
	isbn varchar(15) not null primary key,
	title varchar(50) not null,
	author varchar(10) not null,
	company varchar(50),
	price int(11)
);
insert into bookshop values('88-90-11','오라클 3일완성','이오라','야메루출판사',15000);
insert into bookshop values('90-10-12','jsp달인되기','송JP','공갈닷컴',20000);
insert into bookshop values('87-90-33','자바무따기','김자바','디지탈박스',35000);
