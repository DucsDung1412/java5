CREATE DATABASE j5shop;
USE j5shop;

-- Table: accounts
CREATE TABLE accounts (
    username VARCHAR(50) NOT NULL,
    activated BIT NOT NULL,
    admin BIT NOT NULL,
    email VARCHAR(50) NULL,
    fullname NVARCHAR(50) NULL,
    password VARCHAR(50) NULL,
    photo VARCHAR(50) NULL,
    PRIMARY KEY (username)
);

-- Table: categories
CREATE TABLE categories (
    id VARCHAR(50) NOT NULL,
    name NVARCHAR(50) NULL,
    PRIMARY KEY (id)
);

-- Table: orderdetails (without foreign key constraints)
CREATE TABLE orderdetails (
    id INT AUTO_INCREMENT NOT NULL,
    price FLOAT NULL,
    quantity INT NULL,
    orderid INT NULL,
    productid INT NULL,
    PRIMARY KEY (id)
);

-- Table: orders
CREATE TABLE orders (
    id INT AUTO_INCREMENT NOT NULL,
    address NVARCHAR(50) NULL,
    createdate DATE NULL,
    username VARCHAR(50) NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (username) REFERENCES accounts(username)
);

-- Table: products
CREATE TABLE products (
    id INT AUTO_INCREMENT NOT NULL,
    available BIT NULL,
    createdate DATE NULL,
    image VARCHAR(50) NULL,
    name NVARCHAR(50) NULL,
    price FLOAT NULL,
    categoryid VARCHAR(50) NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (categoryid) REFERENCES categories(id)
);

-- Add foreign key constraints to the orderdetails table
ALTER TABLE orderdetails ADD FOREIGN KEY (orderid) REFERENCES orders(id);
ALTER TABLE orderdetails ADD FOREIGN KEY (productid) REFERENCES products(id);

-- Sample data insertions for accounts and categories (MySQL uses AUTO_INCREMENT for IDENTITY)
INSERT INTO accounts (username, activated, admin, email, fullname, password, photo) VALUES ('phucnh', 1, 1, 'phucnhps19246@fpt.edu.vn', 'Nguyễn Hoàng Phúc', '123', 'phucnh.jpg');

INSERT INTO categories (id, name) VALUES ('DM01', 'Tẩy trang');
INSERT INTO categories (id, name) VALUES ('DM02', 'Sữa rửa mặt');
INSERT INTO categories (id, name) VALUES ('DM03', 'Toner - Xịt khoáng');
INSERT INTO categories (id, name) VALUES ('DM04', 'TEST');


-- Disable automatic increment for MySQL (equivalent to SET IDENTITY_INSERT OFF in SQL Server)
SET foreign_key_checks = 0;

-- Insert data into products table with AUTO_INCREMENT
INSERT INTO products (available, createdate, image, name, price, categoryid) VALUES (1, '2022-03-01', '1.jpg', 'Good night cleanser', 190000, 'DM02');
INSERT INTO products (available, createdate, image, name, price, categoryid) VALUES (1, '2022-03-02', '2.jpg', 'Fairy Water', 350000, 'DM03');
INSERT INTO products (available, createdate, image, name, price, categoryid) VALUES (1, '2022-03-03', '3.jpg', 'Velvet Dream', 380000, 'DM03');
INSERT INTO products (available, createdate, image, name, price, categoryid) VALUES (1, '2022-03-04', '4.jpg', 'Tricky Duet', 190000, 'DM02');
INSERT INTO products (available, createdate, image, name, price, categoryid) VALUES (1, '2022-03-04', '5.jpg', 'Rough Love', 380000, 'DM03');
INSERT INTO products (available, createdate, image, name, price, categoryid) VALUES (1, '2022-03-05', '6.jpg', 'Tender Wonder', 350000, 'DM03');
INSERT INTO products (available, createdate, image, name, price, categoryid) VALUES (1, '2022-03-05', '7.jpg', 'Emmie B5 Cleanser', 230000, 'DM02');

-- Enable foreign key checks again
SET foreign_key_checks = 1;

-- Add foreign key constraints for MySQL
ALTER TABLE orderdetails ADD CONSTRAINT fk_orderdetails_orders FOREIGN KEY (orderid) REFERENCES orders(id);
ALTER TABLE orderdetails ADD CONSTRAINT fk_orderdetails_products FOREIGN KEY (productid) REFERENCES products(id);
ALTER TABLE orders ADD CONSTRAINT fk_orders_accounts FOREIGN KEY (username) REFERENCES accounts(username);
ALTER TABLE products ADD CONSTRAINT fk_products_categories FOREIGN KEY (categoryid) REFERENCES categories(id);