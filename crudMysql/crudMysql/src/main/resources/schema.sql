CREATE TABLE `mydatabase`.`Cliente` (
 `id` INT NOT NULL,
 `nome` VARCHAR(255) NULL,
 `email` VARCHAR(255) NULL,
 `telefone` VARCHAR(45) NULL,
 `cpf` VARCHAR(45) NULL,
 PRIMARY KEY (`id`));

ALTER TABLE `mydatabase`.`Cliente`
 CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ,
 ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC);