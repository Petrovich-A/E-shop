-- USERS
--
CREATE TABLE IF NOT EXISTS users
(
    user_id    SERIAL,
    name       text NOT NULL UNIQUE ,
    password   text NOT NULL UNIQUE ,
    email      text NOT NULL UNIQUE ,
    birth_date date NOT NULL,
    balance    NUMERIC(10, 2) DEFAULT '0.00',
    PRIMARY KEY (user_id)
    );

-- CATEGORIES
--
CREATE TABLE IF NOT EXISTS categories
(
    category_id SERIAL NOT NULL,
    name        text   NOT NULL UNIQUE ,
    rating      int4 DEFAULT 1,
    PRIMARY KEY (category_id),
    CONSTRAINT high_rating CHECK (rating <= 5)
    );

-- PRODUCTS
--
CREATE TABLE IF NOT EXISTS products
(
    product_id  SERIAL NOT NULL,
    name        text   NOT NULL,
    description TEXT,
    price       double precision,
    category_id INTEGER,
    PRIMARY KEY (product_id),
    CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES categories (category_id)
    );

-- ORDERS
--
CREATE TABLE IF NOT EXISTS orders
(
    order_id SERIAL NOT NULL,
    price    double precision,
    date     date   NOT NULL DEFAULT CURRENT_DATE,
    user_id  INTEGER,
    PRIMARY KEY (order_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
    );

-- CARTS
--
CREATE TABLE IF NOT EXISTS carts
(
    cart_id SERIAL NOT NULL,
    price   double precision,
    date    date   NOT NULL DEFAULT CURRENT_DATE,
    user_id INTEGER,
    PRIMARY KEY (cart_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
    );