-- Create category table (ensure it exists before referencing it in 'product')
CREATE TABLE IF NOT EXISTS category (
  id SERIAL PRIMARY KEY, -- Auto-incrementing id for category
  description VARCHAR(255),
  name VARCHAR(255)
);

-- Create product table (referencing category)
CREATE TABLE IF NOT EXISTS product (
  id SERIAL PRIMARY KEY, -- Auto-incrementing id for product
  description VARCHAR(255),
  name VARCHAR(255),
  available_quantity DOUBLE PRECISION NOT NULL,
  price NUMERIC(38, 2),
  category INTEGER,
  CONSTRAINT fk1ghadacategory FOREIGN KEY (category) REFERENCES category(id) -- Correct foreign key reference
);

-- Create sequences for auto-increment
CREATE SEQUENCE IF NOT EXISTS category_seq INCREMENT BY 50 START WITH 1;
CREATE SEQUENCE IF NOT EXISTS product_seq INCREMENT BY 50 START WITH 1;


