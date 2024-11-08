-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema basededatoslab8
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema basededatoslab8
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `basededatoslab8` DEFAULT CHARACTER SET utf8 ;
USE `basededatoslab8` ;

-- -----------------------------------------------------
-- Table `basededatoslab8`.`FavoriteMeal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basededatoslab8`.`FavoriteMeal` (
  `idFavoriteMeal` INT NOT NULL AUTO_INCREMENT,
  `idMeal` VARCHAR(45) NOT NULL,
  `strMeal` VARCHAR(100) NOT NULL,
  `strMealThumb` VARCHAR(150) NOT NULL,
  `strCategory` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idFavoriteMeal`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;