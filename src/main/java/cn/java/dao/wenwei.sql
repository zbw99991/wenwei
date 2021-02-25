/*创建wenwei数据库*/
create database wenwei character set =utf8;
use wenwei;

/*1:导航栏的分类表*/
create table category(id int primary key auto_increment,name varchar(30));
insert into category values(null,'人气活动'),(null,'作品展示'),(null,'最新外景'),(null,'真实客照'),(null,'新闻资讯');
select * from category;

/*2:人气活动*/
create table activity(id int primary key auto_increment,title varchar(30),url varchar(255),created bigint,categoryId int);
