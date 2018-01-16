CREATE TABLE `citrack`.`user_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NULL,
  `last_name` VARCHAR(100) NULL,
  `designation` VARCHAR(45) NULL,
  `drqualifications` VARCHAR(1024) NULL,
  `user_name` VARCHAR(45) NULL,
  `password` VARCHAR(1024) NULL,
  `role` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `patient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `age` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;