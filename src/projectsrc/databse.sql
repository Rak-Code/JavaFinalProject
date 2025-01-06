DROP DATABASE  ecommerce_backend_system;

CREATE DATABASE ecommerce_backend_system;
USE ecommerce_backend_system;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock_quantity INT NOT NULL
);


CREATE TABLE cart_items (
    cart_item_id INT AUTO_INCREMENT PRIMARY KEY,
    cart_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (cart_id) REFERENCES carts(cart_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE order_items (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

INSERT INTO users (username, password, email) 
VALUES 
    ('admin', 'admin123', 'admin@gmail.com'),
    ('user1', 'user123', 'user1@gmail.com');

 


ALTER TABLE cart_items
ADD COLUMN user_id INT NOT NULL;


ALTER TABLE cart_items
ADD CONSTRAINT fk_cart_items_user
FOREIGN KEY (user_id) REFERENCES users(user_id);



INSERT INTO products (name, description, price, stock_quantity) VALUES 
('T-Shirt', 'Cotton t-shirt for casual wear', 700.00, 100),
('Jeans', 'Denim jeans with a classic fit', 1500.00, 60),
('Jacket', 'Warm winter jacket with a hood', 3000.00, 25),
('Sneakers', 'Comfortable sneakers for daily use', 2000.00, 80),
('Cap', 'Stylish cotton cap', 300.00, 150),
('Socks', 'Pack of 3 pairs of socks', 250.00, 200),
('Sweater', 'Knitted sweater for cold weather', 1800.00, 40),
('Shorts', 'Cotton shorts for summer', 600.00, 120),
('Gloves', 'Woolen gloves for winter', 400.00, 75),
('Scarf', 'Silk scarf with a modern design', 500.00, 90);

