CREATE DATABASE prak;
USE prak;

CREATE TABLE film (
	film_id int NOT NULL ,
	name varchar(20) NOT NULL,
	company varchar(20) NOT NULL,
	year DATE NOT NULL,
	producer varchar(20) NOT NULL,
	cd_cost int NOT NULL,
	cassette_cost int NOT NULL,
	PRIMARY KEY (film_id)
) engine=InnoDB;

-- type value: 0 for casette, 1 for cd
CREATE TABLE copy (
	copy_id int NOT NULL ,
	film_id int NOT NULL,
	type bool NOT NULL,
	PRIMARY KEY (copy_id)
) engine=InnoDB;
 
CREATE TABLE rent (
	rent_id int NOT NULL ,
	customer_id int NOT NULL,
	copy_id int NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE,
	payed int NOT NULL,
    PRIMARY KEY (rent_id)
) engine=InnoDB;

CREATE TABLE customer (
	customer_id int NOT NULL ,
	first_name varchar(20) NOT NULL,
	surname varchar(20) NOT NULL,
	patronymic varchar(20) NOT NULL,
	address varchar(50) NOT NULL,
	phone varchar(10) NOT NULL,
	PRIMARY KEY (customer_id)
) engine=InnoDB;

ALTER TABLE copy ADD CONSTRAINT copy_fk0 FOREIGN KEY (film_id) REFERENCES film(film_id);

ALTER TABLE rent ADD CONSTRAINT rent_fk0 FOREIGN KEY (copy_id) REFERENCES copy(copy_id);

ALTER TABLE rent ADD CONSTRAINT rent_fk1 FOREIGN KEY (customer_id) REFERENCES customer(customer_id);

