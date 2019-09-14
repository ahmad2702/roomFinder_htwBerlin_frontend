CREATE SCHEMA `_s0556420__bachelor_frontend` DEFAULT CHARACTER SET utf8;

use `_s0556420__bachelor_frontend`;



CREATE TABLE IF NOT EXISTS `users`(`id` INT NOT NULL AUTO_INCREMENT,`firstname` VARCHAR(100) NOT NULL,`lastname` VARCHAR(100) NOT NULL,`username` VARCHAR(100) NOT NULL,`password` VARCHAR(100) NOT NULL,PRIMARY KEY(`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE IF NOT EXISTS `booking_list`(`id` INT NOT NULL AUTO_INCREMENT,`room` VARCHAR(300),`date` DATE NOT NULL,`begin` DATETIME NOT NULL,`end` DATETIME NOT NULL,`status` VARCHAR(300),PRIMARY KEY(`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE IF NOT EXISTS `booking_users_mapping`(`booking_id` INT NOT NULL,`user_id` INT NOT NULL,FOREIGN KEY(booking_id) REFERENCES booking_list(id),FOREIGN KEY(user_id) REFERENCES users(id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;


* Insert users (pw: http://www.sha1-online.com/): 
* Standard pw: 123456789 

insert into users(firstname, lastname, username,password) values("Alex", "Miller", "s0111001","f7c3bc1d808e04732adf679965ccc34ca7ae3441");
insert into users(firstname, lastname, username,password) values("Max", "Mueller", "s0111002","f7c3bc1d808e04732adf679965ccc34ca7ae3441");
insert into users(firstname, lastname, username,password) values("Sabrina", "Zimmermann", "s0111003","f7c3bc1d808e04732adf679965ccc34ca7ae3441");



insert into booking_list(room,date, begin, end,status) values("C 624","2019-09-09","2019-09-09 11:00:00","2019-09-09 12:00:00","ok");
insert into booking_list(room,date, begin, end,status) values("C 625","2019-09-09","2019-09-09 13:00:00","2019-09-09 14:00:00","ok");
insert into booking_list(room,date, begin, end,status) values("C 626","2019-09-09","2019-09-09 15:00:00","2019-09-09 16:00:00","ok");
insert into booking_list(room,date, begin, end,status) values("C 627","2019-09-09","2019-09-09 17:00:00","2019-09-09 18:00:00","ok");

insert into booking_users_mapping(booking_id,user_id) values(1,1);
insert into booking_users_mapping(booking_id,user_id) values(1,2);
insert into booking_users_mapping(booking_id,user_id) values(2,3);
insert into booking_users_mapping(booking_id,user_id) values(2,2);

# update enable
ALTER TABLE `_s0556420__bachelor_frontend`.`booking_users_mapping` 
DROP FOREIGN KEY `booking_users_mapping_ibfk_1`,
DROP FOREIGN KEY `booking_users_mapping_ibfk_2`;
ALTER TABLE `_s0556420__bachelor_frontend`.`booking_users_mapping` 
ADD CONSTRAINT `booking_users_mapping_ibfk_1`
  FOREIGN KEY (`booking_id`)
  REFERENCES `_s0556420__bachelor_frontend`.`booking_list` (`id`)
  ON DELETE CASCADE
  ON UPDATE RESTRICT,
ADD CONSTRAINT `booking_users_mapping_ibfk_2`
  FOREIGN KEY (`user_id`)
  REFERENCES `_s0556420__bachelor_frontend`.`users` (`id`)
  ON DELETE CASCADE
  ON UPDATE RESTRICT;



