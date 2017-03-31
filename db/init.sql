CREATE DATABASE prak;
USE prak;

CREATE TABLE film (
	film_id int NOT NULL AUTO_INCREMENT,
	name varchar(20),
	company varchar(20),
	year DATE,
	producer varchar(20),
	cd_cost int,
	cassette_cost int,
	PRIMARY KEY (film_id)
) engine=InnoDB;

-- type value: 0 for casette, 1 for cd
CREATE TABLE copy (
	copy_id int NOT NULL AUTO_INCREMENT,
	film_id int NOT NULL,
	type bool NOT NULL,
	PRIMARY KEY (copy_id)
) engine=InnoDB;
 
CREATE TABLE rent (
	rent_id int NOT NULL AUTO_INCREMENT,
	customer_id int NOT NULL,
	copy_id int NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE,
	payed int NOT NULL,
    PRIMARY KEY (rent_id)
) engine=InnoDB;

CREATE TABLE customer (
	customer_id int NOT NULL AUTO_INCREMENT,
	first_name varchar(20),
	surname varchar(20),
	patronymic varchar(20),
	address varchar(50),
	phone varchar(10),
	PRIMARY KEY (customer_id)
) engine=InnoDB;

ALTER TABLE copy ADD CONSTRAINT copy_fk0 FOREIGN KEY (film_id) REFERENCES film(film_id) ON DELETE CASCADE;

ALTER TABLE rent ADD CONSTRAINT rent_fk0 FOREIGN KEY (copy_id) REFERENCES copy(copy_id) ON DELETE CASCADE;

ALTER TABLE rent ADD CONSTRAINT rent_fk1 FOREIGN KEY (customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE;

