INSERT INTO roles (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO users (name, password, email, birth_date, balance, role_id)
values ('Wade', '$2a$10$0ZrU1zZA2gx9lBm2MQ1Id.gN7Itm8a8Xi3AComXN2CZXZzHCclh..', 'williams@mail.com', '01-01-1990', 0.5, 1),
       ('Dave', '$2a$10$XtGZF/tA.hNaFsDN6MEKYOTcFS.52OFv0U0UZUWjCl34SgDJVenBG', 'harris@mail.com', '01-01-1990', 0.5, 1),
       ('Seth', '$2a$10$V4WWGilNB2JWcYNVXXz5eOZAessEAuKE5znzGkUGmvJcDxvBL/mam', 'thomas@mail.com', '01-01-1990', 15.5, 1),
       ('admin', '$2a$10$gPjW84sOushTvbyBVe/yguuirVIzQCHvlXwIizh4./xqLLKoK2HJq', 'admin@mail.com', '01-01-1990', 0.5, 2);

INSERT INTO categories (name, rating)
values ('category1', 1),
       ('category2', 2),
       ('category3', 3),
       ('category4', 4),
       ('category5', 5);

INSERT INTO products (name, description, price, category_id)
VALUES ('product name1',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        19.99, 1),
       ('product name2',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        24.95, 1),
       ('product name3',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        10.99, 1),
       ('product name3',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        10.99, 1),
       ('product name3',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        10.99, 2),
       ('product name3',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        10.99, 2),
       ('product name3',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        10.99, 2),
       ('product name3',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        10.99, 3),
       ('product name3',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        10.99, 3),
       ('product name3',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        10.99, 3),
       ('product name3',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        10.99, 4),
       ('product name3',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        10.99, 4),
       ('product name3',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        10.99, 4),
       ('product name3',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        10.99, 5),
       ('product name3',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        10.99, 5),
       ('product name3',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        10.99, 5),
       ('product name4',
        'Our product is a versatile and high-quality backpack designed for the modern adventurer. With multiple pockets and compartments, it provides ample space for all your gear, whether you''re hitting the trails or a bustling city. Made from durable materials, it''s built to withstand the elements and last for years to come.',
        16.50, 5);

INSERT INTO orders (price, user_id, created_at)
VALUES (100.00, 1, CURRENT_TIMESTAMP),
       (19.99, 1, CURRENT_TIMESTAMP),
       (200.00, 2, CURRENT_TIMESTAMP),
       (25.00, 2, CURRENT_TIMESTAMP),
       (50.00, 2, CURRENT_TIMESTAMP),
       (0.30, 3, CURRENT_TIMESTAMP);

INSERT INTO carts (price, created_at, user_id)
VALUES (50.55, CURRENT_TIMESTAMP, 1),
       (10.99, CURRENT_TIMESTAMP, 2),
       (0.5, CURRENT_TIMESTAMP, 3);