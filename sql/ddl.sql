drop table if exists member CASCADE;
create table member
(
    id bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);

insert into member(name) values('안녕');

select * from member;