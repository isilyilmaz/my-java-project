-- Database: bankingsystem

-- DROP DATABASE IF EXISTS bankingsystem;

CREATE DATABASE bankingsystem
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;


--DROP TABLE Transaction;
--DROP TABLE Card;
--DROP TABLE Customer;

-- Customer Table
CREATE TABLE Customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
	surname VARCHAR(100),
	birth_date DATE,
	gender VARCHAR(10),
    email VARCHAR(100),
    address VARCHAR(200),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Card Table
CREATE TABLE Card (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER REFERENCES Customer(id),
    card_number VARCHAR(16) UNIQUE,
    card_type VARCHAR(20),
    expiration_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Transaction Table
CREATE TABLE Transaction (
    id SERIAL PRIMARY KEY,
    card_id INTEGER REFERENCES Card(id),
    amount DECIMAL(10, 2),
    transaction_code VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
