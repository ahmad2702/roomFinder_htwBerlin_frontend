1. Create db for users:

CREATE SCHEMA `_s0556420__bachelor_frontend` DEFAULT CHARACTER SET utf8 ;

2.
CREATE TABLE IF NOT EXISTS `user`(`id` INT NOT NULL AUTO_INCREMENT,`username` VARCHAR(100) NOT NULL,`password` VARCHAR(100) NOT NULL,PRIMARY KEY(`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

3. Insert users (pw: http://www.sha1-online.com/): 
standard pw: 123456789 

insert into user(username,password) values("s0111001","f7c3bc1d808e04732adf679965ccc34ca7ae3441");
insert into user(username,password) values("s0111002","f7c3bc1d808e04732adf679965ccc34ca7ae3441");
insert into user(username,password) values("s0111003","f7c3bc1d808e04732adf679965ccc34ca7ae3441");