USE jpa2021;

DROP TABLE IF EXISTS `autorzy_to_ksiazki`;
DROP TABLE IF EXISTS `ksiazki`;
DROP TABLE IF EXISTS `kategorie`;
DROP TABLE IF EXISTS `autorzy`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `kategorie`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `nazwa` VARCHAR(40) NOT NULL,
    constraint `kategorie_pk` PRIMARY KEY(`id`)
);

CREATE TABLE `ksiazki`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`nazwa` VARCHAR(100) NOT NULL,
	`wydawnictwo` VARCHAR(50) NOT NULL,
	`cena` FLOAT NOT NULL,
	`kategoria_id` INT DEFAULT NULL,
	constraint `ksiazki_pk` PRIMARY KEY(`id`),
	constraint `ksiazki_kategorie_fk` FOREIGN KEY(`kategoria_id`) REFERENCES `kategorie` (`id`)
);

CREATE TABLE `autorzy`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `imie` VARCHAR(30) NOT NULL,
    `nazwisko` VARCHAR(40) NOT NULL,
    constraint `autorzy_pk` PRIMARY KEY(`id`)
);

CREATE TABLE `autorzy_to_ksiazki` (
	`ksiazka_id` INT NOT NULL,
	`autor_id` INT NOT NULL,
	constraint `autorzy_to_ksiazki_pk` PRIMARY KEY(`ksiazka_id`, `autor_id`),
	constraint `autorzy_to_ksiazki_ksiazki_fk` FOREIGN KEY (`ksiazka_id`) REFERENCES `ksiazki`(`id`),
	constraint `autorzy_to_ksiazki_autorzy_fk`FOREIGN KEY (`autor_id`) REFERENCES `autorzy`(`id`)
);

CREATE TABLE `users`(
	`username` VARCHAR(25) NOT NULL,
    `password` VARCHAR(60) NOT NULL,
    `enabled` BOOLEAN NOT NULL DEFAULT TRUE,
    constraint `users_pk` PRIMARY KEY(`username`)
);


CREATE TABLE `authorities` (
`username` varchar(50) NOT NULL,
`authority` varchar(50) NOT NULL,
UNIQUE KEY `authorieties_idx_1` (`username`, `authority`),
CONSTRAINT `authorities_ibfk_1`
foreign key (`username`)
REFERENCES `users` (`username`)
);

INSERT INTO `kategorie` VALUES (1, 'Literatura polska');
INSERT INTO `kategorie` VALUES (2, 'Literatura zagraniczna');

INSERT INTO `ksiazki`(`nazwa`,`wydawnictwo`,`cena`,`kategoria_id`) VALUES ( 'Hamlet', 'AAA', 6.5, 2);
INSERT INTO `ksiazki`(`nazwa`,`wydawnictwo`,`cena`,`kategoria_id`) VALUES ('Makbet', 'AAA', 6.8, 2);
INSERT INTO `ksiazki`(`nazwa`,`wydawnictwo`,`cena`,`kategoria_id`) VALUES ('Potop', 'BBB', 18.4, 1);
INSERT INTO `ksiazki`(`nazwa`,`wydawnictwo`,`cena`,`kategoria_id`) VALUES ('Quo vadis', 'BBB', 17.99, 1);
INSERT INTO `ksiazki`(`nazwa`,`wydawnictwo`,`cena`,`kategoria_id`) VALUES ('Pan Tadeusz', 'CCC', 13.78, 1);
INSERT INTO `ksiazki`(`nazwa`,`wydawnictwo`,`cena`,`kategoria_id`) VALUES ('Nad Niemnem', 'CCC', 15.45, 1);

INSERT INTO `autorzy` (`imie` , `nazwisko`) VALUES ('William', 'Shakespeare'), ('Henryk', 'Sienkiewicz'), ('Adam', 'Mickiewicz'), ('Eliza', 'Orzeszkowa'), ('Jan', 'Kowalski');

INSERT INTO `autorzy_to_ksiazki` VALUES (1, 1);
INSERT INTO `autorzy_to_ksiazki` VALUES (1, 5);
INSERT INTO `autorzy_to_ksiazki` VALUES (2, 1);
INSERT INTO `autorzy_to_ksiazki` VALUES (2, 5);
INSERT INTO `autorzy_to_ksiazki` VALUES (3, 2);
INSERT INTO `autorzy_to_ksiazki` VALUES (4, 2);
INSERT INTO `autorzy_to_ksiazki` VALUES (5, 3);
INSERT INTO `autorzy_to_ksiazki` VALUES (6, 4);
