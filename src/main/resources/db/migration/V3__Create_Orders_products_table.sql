-- Creating junction table order_product
--
CREATE TABLE orders_products
(
    order_id   INTEGER REFERENCES orders (order_id),
    product_id INTEGER REFERENCES products (product_id)
);
