-- Create category table (ensure it exists before referencing it in 'product')
SET AUTOCOMMIT = 1;

-- Create the category table if it doesn't exist
CREATE TABLE IF NOT EXISTS category (
  id INTEGER PRIMARY KEY, -- Manually provided id for category
  description VARCHAR(255),
  name VARCHAR(255)
);

-- Create product table (referencing category)
CREATE TABLE IF NOT EXISTS product (
  id INTEGER PRIMARY KEY, -- Manually provided id for product
  description VARCHAR(255),
  name VARCHAR(255),
  available_quantity DOUBLE PRECISION NOT NULL,
  price NUMERIC(38, 2),
  category INTEGER,
  CONSTRAINT fk1ghadacategory FOREIGN KEY (category) REFERENCES category(id) -- Correct foreign key reference
);

-- Insert data into the category table with manually specified ids
INSERT INTO category (id, description, name)
VALUES
  (1, 'Category 1 Description', 'Category 1'),
  (2, 'Category 2 Description', 'Category 2'),
  (3, 'Category 3 Description', 'Category 3');

-- Insert data into the product table with manually specified ids and referencing the correct category id
INSERT INTO product (id, description, name, available_quantity, price, categoryid)
VALUES
  (1, 'Product 1 Description', 'Product 1', 100, 19.99, 1), -- referencing category id 1
  (2, 'Product 2 Description', 'Product 2', 200, 29.99, 2), -- referencing category id 2
  (3, 'Product 3 Description', 'Product 3', 150, 39.99, 3); -- referencing category id 3
