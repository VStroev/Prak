USE prak;

INSERT `Film` VALUE (0, 'Dogville', 'Isabella Films', STR_TO_DATE('1-01-2003', '%d-%m-%Y'), 'Lars von Trier', 300, 100);
INSERT `Film` VALUE (1, 'Paradise', 'DRIFE Productions', STR_TO_DATE('1-01-2016', '%d-%m-%Y'), 'Andrey Konchalovskiy', 250, 150);
INSERT `Film` VALUE (2, 'Inception', 'Warner Bros', STR_TO_DATE('1-01-2010', '%d-%m-%Y'), 'Christopher Nolan', 400, 200);
INSERT `Film` VALUE (3, 'Todo sobre mi madre', 'El Deseo S.A.', STR_TO_DATE('1-01-1999', '%d-%m-%Y'), 'Pedro Almodóvar', 350, 200);
INSERT `Film` VALUE (4, 'Solaris', 'Mosfilm', STR_TO_DATE('1-01-1972', '%d-%m-%Y'), 'Andrey Tarkovskiy', 290, 100);

INSERT `customer` VALUE (0, 'Alexander', 'Portnoy', 'Mihailovich', 'Student\'s House on Lomonosovskiy', 8800553535);
INSERT `customer` VALUE (1, 'Andrey', 'Zhabotinskiy', 'Andreevich', 'Student\'s House on Lomonosovskiy', 8800553500);
INSERT `customer` VALUE (2, 'Vasiliy', 'Zhikov', 'Borisovich', 'Student\'s House on Lomonosovskiy', 8800553501);
INSERT `customer` VALUE (3, 'Elena', 'Aksenova', 'Leonidovna', 'Moscow', 8800553502);
INSERT `customer` VALUE (4, 'Akakiy', 'Akakiev', 'Akakievich', 'Moscow', 8800553503);

INSERT `copy` VALUE (0, 0, 0);
INSERT `copy` VALUE (1, 0, 1);
INSERT `copy` VALUE (2, 1, 0);
INSERT `copy` VALUE (3, 1, 1);
INSERT `copy` VALUE (4, 2, 0);
INSERT `copy` VALUE (5, 2, 1);
INSERT `copy` VALUE (6, 3, 0);
INSERT `copy` VALUE (7, 3, 1);
INSERT `copy` VALUE (8, 4, 0);
INSERT `copy` VALUE (9, 4, 1);

INSERT `rent` VALUE (0, 1, STR_TO_DATE('15-12-2016', '%d-%m-%Y'), NULL, 300);
INSERT `rent` VALUE (0, 3, STR_TO_DATE('5-01-2017', '%d-%m-%Y'), NULL, 350);
INSERT `rent` VALUE (1, 2, STR_TO_DATE('5-01-2017', '%d-%m-%Y'), STR_TO_DATE('8-01-2017', '%d-%m-%Y'), 350);
INSERT `rent` VALUE (3, 2, STR_TO_DATE('9-01-2017', '%d-%m-%Y'), STR_TO_DATE('11-01-2017', '%d-%m-%Y'), 350);
INSERT `rent` VALUE (4, 0, STR_TO_DATE('8-01-2017', '%d-%m-%Y'), STR_TO_DATE('10-01-2017', '%d-%m-%Y'), 150);
INSERT `rent` VALUE (2, 8, STR_TO_DATE('1-01-2017', '%d-%m-%Y'), STR_TO_DATE('2-01-2017', '%d-%m-%Y'), 120);
INSERT `rent` VALUE (2, 8, STR_TO_DATE('3-01-2017', '%d-%m-%Y'), STR_TO_DATE('4-01-2017', '%d-%m-%Y'), 100);
INSERT `rent` VALUE (2, 8, STR_TO_DATE('3-01-2017', '%d-%m-%Y'), STR_TO_DATE('4-01-2017', '%d-%m-%Y'), 200);
INSERT `rent` VALUE (1, 8, STR_TO_DATE('4-01-2017', '%d-%m-%Y'), STR_TO_DATE('10-01-2017', '%d-%m-%Y'), 100);
INSERT `rent` VALUE (1, 6, STR_TO_DATE('10-01-2017', '%d-%m-%Y'), NULL, 300);