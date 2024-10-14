CREATE DATABASE IF NOT EXISTS online_bookstore;

USE online_bookstore;

CREATE TABLE IF NOT EXISTS books (
    id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    uuid VARCHAR(36) NOT NULL,  -- UUIDs are typically stored as 36 characters
    image_url VARCHAR(255),
    author VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,  -- TEXT type is used for potentially long descriptions
    qty INT DEFAULT 0,          -- Default quantity is set to 0
    price DECIMAL(10, 2) NOT NULL,  -- Precision of 10 digits, 2 after the decimal
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS Contact (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fullName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phoneNumber INT NOT NULL,
    subject VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    status VARCHAR(50) NOT NULL,
    createdAt TIMESTAMP NOT NULL,       -- Handled by JPA Auditing
    createdBy VARCHAR(255) NOT NULL,    -- Handled by JPA Auditing
    updatedAt TIMESTAMP NOT NULL,       -- Handled by JPA Auditing
    updatedBy VARCHAR(255)NOT NULL      -- Handled by JPA Auditing
);

CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
   PRIMARY KEY (`role_id`)
);

CREATE TABLE IF NOT EXISTS `address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `address1` varchar(200) NOT NULL,
  `address2` varchar(200) DEFAULT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `zip_code` int NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
   PRIMARY KEY (`address_id`)
);

CREATE TABLE IF NOT EXISTS `person` (
  `person_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `pwd` varchar(200) NOT NULL,
  `role_id` int NOT NULL,
  `address_id` int NULL,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
   PRIMARY KEY (`person_id`),
   FOREIGN KEY (role_id) REFERENCES roles(role_id),
   FOREIGN KEY (address_id) REFERENCES address(address_id)
);

