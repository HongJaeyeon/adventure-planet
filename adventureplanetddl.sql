-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema enjoytrip
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema enjoytrip
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `enjoytrip` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `enjoytrip` ;

-- -----------------------------------------------------
-- Table `enjoytrip`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`user` (
  `user_id` VARCHAR(20) NOT NULL,
  `user_email` VARCHAR(50) NOT NULL,
  `user_password` VARCHAR(80) NOT NULL,
  `user_name` VARCHAR(20) NOT NULL,
  `user_position` VARCHAR(10) NOT NULL DEFAULT 'user',
  `user_status` INT NOT NULL DEFAULT '1',
  `user_token` VARCHAR(1000) NULL DEFAULT NULL,
  `user_join_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_email_UNIQUE` (`user_email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`article` (
  `article_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NULL DEFAULT NULL,
  `article_title` VARCHAR(100) NOT NULL,
  `article_content` TEXT NULL DEFAULT NULL,
  `article_status` INT NOT NULL DEFAULT '1',
  `article_hit` INT NULL DEFAULT '0',
  `article_write_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_no`),
  INDEX `fk_article_user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_article_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 208
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`sido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`sido` (
  `sido_code` INT NOT NULL,
  `sido_name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`gugun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`gugun` (
  `gugun_code` INT NOT NULL,
  `gugun_name` VARCHAR(30) NULL DEFAULT NULL,
  `sido_code` INT NOT NULL,
  PRIMARY KEY (`gugun_code`, `sido_code`),
  INDEX `gugun_to_sido_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  CONSTRAINT `gugun_to_sido_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `enjoytrip`.`sido` (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_info` (
  `content_id` INT NOT NULL,
  `content_type_id` INT NULL DEFAULT NULL,
  `title` VARCHAR(100) NULL DEFAULT NULL,
  `addr1` VARCHAR(100) NULL DEFAULT NULL,
  `addr2` VARCHAR(50) NULL DEFAULT NULL,
  `zipcode` VARCHAR(50) NULL DEFAULT NULL,
  `tel` VARCHAR(50) NULL DEFAULT NULL,
  `first_image` VARCHAR(200) NULL DEFAULT NULL,
  `first_image2` VARCHAR(200) NULL DEFAULT NULL,
  `readcount` INT NULL DEFAULT NULL,
  `sido_code` INT NULL DEFAULT NULL,
  `gugun_code` INT NULL DEFAULT NULL,
  `latitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `longitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `mlevel` VARCHAR(2) NULL DEFAULT NULL,
  `recommendation` INT NOT NULL DEFAULT '0',
  PRIMARY KEY (`content_id`),
  INDEX `attraction_to_content_type_id_fk_idx` (`content_type_id` ASC) VISIBLE,
  INDEX `attraction_to_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  INDEX `attraction_to_gugun_code_fk_idx` (`gugun_code` ASC) VISIBLE,
  CONSTRAINT `attraction_to_content_type_id_fk`
    FOREIGN KEY (`content_type_id`)
    REFERENCES `enjoytrip`.`content_type` (`content_type_id`),
  CONSTRAINT `attraction_to_gugun_code_fk`
    FOREIGN KEY (`gugun_code`)
    REFERENCES `enjoytrip`.`gugun` (`gugun_code`),
  CONSTRAINT `attraction_to_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `enjoytrip`.`sido` (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_description`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_description` (
  `content_id` INT NOT NULL,
  `homepage` VARCHAR(100) NULL DEFAULT NULL,
  `overview` VARCHAR(10000) NULL DEFAULT NULL,
  `telname` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  CONSTRAINT `attraction_detail_to_attraciton_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_detail` (
  `content_id` INT NOT NULL,
  `cat1` VARCHAR(3) NULL DEFAULT NULL,
  `cat2` VARCHAR(5) NULL DEFAULT NULL,
  `cat3` VARCHAR(9) NULL DEFAULT NULL,
  `created_time` VARCHAR(14) NULL DEFAULT NULL,
  `modified_time` VARCHAR(14) NULL DEFAULT NULL,
  `booktour` VARCHAR(5) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  CONSTRAINT `attraction_detail_to_basic_content_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`plan` (
  `plan_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NULL DEFAULT NULL,
  `plan_title` VARCHAR(100) NOT NULL,
  `plan_status` INT NOT NULL DEFAULT '1',
  `plan_create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `plan_content` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`plan_no`),
  INDEX `fk_plan_user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_plan_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 40
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`day`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`day` (
  `day_no` INT NOT NULL AUTO_INCREMENT,
  `plan_no` INT NULL DEFAULT NULL,
  `day_order` INT NOT NULL,
  `day_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `day_status` INT NOT NULL DEFAULT '1',
  `day_add_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`day_no`),
  INDEX `fk_day_plan_no_idx` (`plan_no` ASC) VISIBLE,
  CONSTRAINT `fk_day_plan_no`
    FOREIGN KEY (`plan_no`)
    REFERENCES `enjoytrip`.`plan` (`plan_no`))
ENGINE = InnoDB
AUTO_INCREMENT = 49
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`favorite` (
  `favorite_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NULL DEFAULT NULL,
  `content_id` INT NULL DEFAULT NULL,
  `favorite_status` INT NOT NULL DEFAULT '1',
  `favorite_add_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`favorite_no`),
  INDEX `fk_favorite_user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_favorite_content_id_idx` (`content_id` ASC) VISIBLE,
  CONSTRAINT `fk_favorite_content_id`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`),
  CONSTRAINT `fk_favorite_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`photo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`photo` (
  `photo_no` INT NOT NULL AUTO_INCREMENT,
  `article_no` INT NULL DEFAULT NULL,
  `plan_no` INT NULL DEFAULT NULL,
  `photo_original_name` VARCHAR(1000) NOT NULL,
  `photo_save_name` VARCHAR(1000) NOT NULL,
  `photo_status` INT NOT NULL DEFAULT '1',
  `photo_add_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`photo_no`),
  INDEX `fk_photo_article_no_idx` (`article_no` ASC) VISIBLE,
  INDEX `fk_photo_plan_no_idx` (`plan_no` ASC) VISIBLE,
  CONSTRAINT `fk_photo_article_no`
    FOREIGN KEY (`article_no`)
    REFERENCES `enjoytrip`.`article` (`article_no`),
  CONSTRAINT `fk_photo_plan_no`
    FOREIGN KEY (`plan_no`)
    REFERENCES `enjoytrip`.`plan` (`plan_no`))
ENGINE = InnoDB
AUTO_INCREMENT = 27
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`request` (
  `request_no` INT NOT NULL AUTO_INCREMENT,
  `from_user_id` VARCHAR(20) NULL DEFAULT NULL,
  `plan_no` INT NULL DEFAULT NULL,
  `to_user_id` VARCHAR(20) NULL DEFAULT NULL,
  `request_status` INT NOT NULL DEFAULT '1',
  `request_create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`request_no`),
  INDEX `fk_request_from_user_id_idx` (`from_user_id` ASC) VISIBLE,
  INDEX `fk_request_to_user_id_idx` (`to_user_id` ASC) VISIBLE,
  INDEX `fk_request_plan_no_idx` (`plan_no` ASC) VISIBLE,
  CONSTRAINT `fk_request_from_user_id`
    FOREIGN KEY (`from_user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`),
  CONSTRAINT `fk_request_plan_no`
    FOREIGN KEY (`plan_no`)
    REFERENCES `enjoytrip`.`plan` (`plan_no`),
  CONSTRAINT `fk_request_to_user_id`
    FOREIGN KEY (`to_user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`share`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`share` (
  `share_no` INT NOT NULL AUTO_INCREMENT,
  `from_user_id` VARCHAR(20) NULL DEFAULT NULL,
  `plan_no` INT NULL DEFAULT NULL,
  `to_user_id` VARCHAR(20) NULL DEFAULT NULL,
  `share_status` INT NOT NULL DEFAULT '1',
  `share_create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`share_no`),
  INDEX `fk_share_from_user_id_idx` (`from_user_id` ASC) VISIBLE,
  INDEX `fk_share_to_user_id_idx` (`to_user_id` ASC) VISIBLE,
  INDEX `fk_share_plan_no_idx` (`plan_no` ASC) VISIBLE,
  CONSTRAINT `fk_share_from_user_id`
    FOREIGN KEY (`from_user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`),
  CONSTRAINT `fk_share_plan_no`
    FOREIGN KEY (`plan_no`)
    REFERENCES `enjoytrip`.`plan` (`plan_no`),
  CONSTRAINT `fk_share_to_user_id`
    FOREIGN KEY (`to_user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`waypoint`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`waypoint` (
  `waypoint_no` INT NOT NULL AUTO_INCREMENT,
  `day_no` INT NULL DEFAULT NULL,
  `content_id` INT NULL DEFAULT NULL,
  `waypoint_order` INT NOT NULL,
  `waypoint_content` TEXT NULL DEFAULT NULL,
  `waypoint_status` INT NOT NULL DEFAULT '1',
  `waypoint_add_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`waypoint_no`),
  INDEX `fk_waypoint_content_id_idx` (`content_id` ASC) VISIBLE,
  INDEX `fk_waypoint_day_no_idx` (`day_no` ASC) VISIBLE,
  CONSTRAINT `fk_waypoint_content_id`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`),
  CONSTRAINT `fk_waypoint_day_no`
    FOREIGN KEY (`day_no`)
    REFERENCES `enjoytrip`.`day` (`day_no`))
ENGINE = InnoDB
AUTO_INCREMENT = 128
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
