create database productsdb;
use productsdb;
CREATE table if not exists product(
id int auto_increment primary key ,
name varchar(20), 
description varchar(200),
price decimal(8,3)

);