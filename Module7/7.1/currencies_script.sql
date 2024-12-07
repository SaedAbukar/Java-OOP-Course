DROP DATABASE IF EXISTS currency_db;
CREATE DATABASE currency_db;
USE currency_db;

-- Create the table to store Currency objects
CREATE TABLE CURRENCIES
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    abbreviation  VARCHAR(10)    NOT NULL,
    currency_name VARCHAR(50)    NOT NULL,
    exchange_rate DECIMAL(10, 4) NOT NULL
);

-- Populate the table with some example currencies and their exchange rates
INSERT INTO CURRENCIES (abbreviation, currency_name, exchange_rate)
VALUES ('USD', 'United States Dollar', 1.0000),
       ('EUR', 'Euro', 0.9515),
       ('GBP', 'British Pound', 0.7891),
       ('JPY', 'Japanese Yen', 149.60),
       ('AUD', 'Australian Dollar', 1.5425),
       ('CAD', 'Canadian Dollar', 1.4067),
       ('CHF', 'Swiss Franc', 0.8862),
       ('CNY', 'Chinese Yuan', 7.2853);

-- Drop the user account 'appuser' if it exists
DROP USER IF EXISTS 'saed'@'localhost';

-- Create the 'appuser' account with a secure password
CREATE USER 'saed'@'localhost' IDENTIFIED BY '12345678';

-- Grant appropriate privileges to 'appuser'
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE ON currency_db.* TO 'saed'@'localhost';

-- Flush privileges to apply the changes
FLUSH PRIVILEGES;