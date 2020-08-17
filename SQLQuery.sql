create database LibraryManagement
use LibraryManagement

create table Book(
id int primary key,
name nvarchar (50),
author nvarchar(50),
publisher nvarchar (50),
total int,
available int,
publishYear date,
status bit
)

create table Order (
id int primary key,
userID nvarchar(50) ,
borrowDate date,
returnDate date,
returned bit 
)

create table OrderDetail (
orderID int,
bookID int,
quantity int,
note nvarchar(50)
)

create table User (
id nvarchar primary key, 
password nvarchar (50),
roleID nvarchar (50),
fullName nvarchar (50),
gender nvarchar (50),
phone nvarchar (50),
address nvarchar (50) ,
status bit
)












