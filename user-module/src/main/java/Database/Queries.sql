 create database user;
 create user 'user'@'localhost' identified by 'system';
 grant all on user.* to 'user'@'localhost';
 CREATE TABLE USER_INFO (ID INT PRIMARY KEY, NAME VARCHAR(30),PASSWORD VARCHAR(30));