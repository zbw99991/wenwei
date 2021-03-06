/*创建wenwei数据库*/
drop database wenwei;
show databases ;
create database wenwei character set =utf8;
use wenwei;
show tables ;

/*1.用户*/
create table user(id int primary key auto_increment,username varchar(30),password varchar(30));
select * from user;

/*2:导航栏的分类表*/
create table category(id int primary key auto_increment,name varchar(30));
insert into category values(null,'人气活动'),(null,'作品展示'),
                            (null,'最新外景'),(null,'真实客照');
drop table category;
select * from category;

/*3.轮播图类型*/
create table banner(id int primary key auto_increment,bannerId int,name varchar(30));
insert into banner values (null,1,"home.html大号轮播图");
insert into banner values (null,2,"home.html中号轮播图");
insert into banner values (null,3,"home.html小号轮播图");
insert into banner values (null,4,"分页轮播图");

/*4轮播图*/
create table banner_img(id int primary key auto_increment,bannerId int,url varchar(255),created bigint);

/*5:图片信息*/
create table picture(id int primary key auto_increment,title varchar(30),author varchar(20),intro varchar(255),
        url varchar(255),created bigint,categoryId int,countdown bigint,viewCount int);



