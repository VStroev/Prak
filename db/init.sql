create database prak;
USE prak;

CREATE TABLE `Film` (
	`film_id` int NOT NULL,
	`name` varchar(20) NOT NULL,
	`company` varchar(20) NOT NULL,
	`year` DATE NOT NULL,
	`producer` varchar(20) NOT NULL,
	`cd_cost` int NOT NULL,
	`cassette_cost` int NOT NULL,
	PRIMARY KEY (`film_id`)
);

CREATE TABLE `copy` (
	`copy_id` int NOT NULL,
	`film_id` int NOT NULL,
	`type` bool NOT NULL,
	PRIMARY KEY (`copy_id`)
);

CREATE TABLE `rent` (
	`start_date` DATE NOT NULL,
	`end_date` DATE,
	`copy_id` int NOT NULL,
	`customer_id` int NOT NULL,
	`payed` int
);

CREATE TABLE `customer` (
	`customer_id` int NOT NULL,
	`first name` varchar(20) NOT NULL,
	`surname` varchar(20) NOT NULL,
	`patronymic` varchar(20) NOT NULL,
	`adress` varchar(30) NOT NULL,
	`phone` DECIMAL(10) NOT NULL,
	PRIMARY KEY (`customer_id`)
);

ALTER TABLE `copy` ADD CONSTRAINT `copy_fk0` FOREIGN KEY (`film_id`) REFERENCES `Film`(`film_id`);

ALTER TABLE `rent` ADD CONSTRAINT `rent_fk0` FOREIGN KEY (`copy_id`) REFERENCES `copy`(`copy_id`);

ALTER TABLE `rent` ADD CONSTRAINT `rent_fk1` FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`);

