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