DROP TABLE IF EXISTS `dish`;

CREATE TABLE `dish` (
  `dish_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(256) NOT NULL,
  `price` DECIMAL(10, 2) NOT NULL,
  `description` VARCHAR(1024) DEFAULT NULL,
  `picture` VARCHAR(32) DEFAULT NULL,
  PRIMARY KEY (`dish_id`)
);


DROP TABLE IF EXISTS `menu_dish`;

CREATE TABLE `menu_dish` (
  `dish_id` INT NOT NULL AUTO_INCREMENT,
  `weekday` TINYINT NOT NULL,
  PRIMARY KEY (`dish_id`, `weekday`)
);


DROP TABLE IF EXISTS `lunchbox`;

CREATE TABLE `lunchbox` (
  `lunchbox_id` INT NOT NULL AUTO_INCREMENT,
  `order_id` INT NOT NULL,
  `quantity` TINYINT NOT NULL,
  `price` DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (`lunchbox_id`)
);


DROP TABLE IF EXISTS `lunchbox_dish`;

CREATE TABLE `lunchbox_dish` (
  `lunchbox_id` INT NOT NULL,
  `dish_id` INT NOT NULL,
  `quantity` TINYINT NOT NULL,
  PRIMARY KEY (`lunchbox_id`, `dish_id`)
);


DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `reference_no` VARCHAR(32) NOT NULL,
  `collection_point` VARCHAR(1024) NOT NULL,
  `contact_number` VARCHAR(256) NOT NULL,
  `amount` DECIMAL(10, 2) NOT NULL,
  `create_datetime` DATETIME NOT NULL,
  PRIMARY KEY (`order_id`)
);