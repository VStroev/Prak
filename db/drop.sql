USE prak;

ALTER TABLE `copy` DROP FOREIGN KEY `copy_fk0`;

ALTER TABLE `rent` DROP FOREIGN KEY `rent_fk0`;

ALTER TABLE `rent` DROP FOREIGN KEY `rent_fk1`;

DROP TABLE IF EXISTS `Film`;

DROP TABLE IF EXISTS `copy`;

DROP TABLE IF EXISTS `rent`;

DROP TABLE IF EXISTS `customer`;

drop database prak;