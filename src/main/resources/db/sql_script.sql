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
  `gender` varchar(10) DEFAULT NULL,
  `height` decimal(10,2) DEFAULT NULL,
  `weight` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;


CREATE TABLE `prescription` (
  `id` int(11) NOT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `prescription_item` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dose` varchar(255) DEFAULT NULL,
  `others_dose` varchar(255) DEFAULT NULL,
  `prescription_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeykn9e2g6nbmvwhqbrdm3jb2p` (`prescription_id`),
  CONSTRAINT `FKeykn9e2g6nbmvwhqbrdm3jb2p` FOREIGN KEY (`prescription_id`) REFERENCES `prescription` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--mongod --dbpath /Users/rkarim/works/mongodb/data/db