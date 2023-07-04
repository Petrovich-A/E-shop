INSERT INTO users (name, password, email, birth_date, balance, role_id)
values ('Wade', 'Williams', 'williams@mail.com', '01-01-1990', 0.5, 1),
       ('Dave', 'Harris', 'harris@mail.com', '01-01-1990', 0.5, 1),
       ('Seth', 'Thomas', 'thomas@mail.com', '01-01-1990', 15.5, 1),
       ('admin', '$2a$10$an1GB52whsATPp.1SulvUun3WnF.8c5k/4BgQwh4S/OpMr9wO.SDm', 'admin@mail.com', '01-01-1990', 0.5, 2);

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
VALUES (0.10, 1, CURRENT_TIMESTAMP),
       (0.20, 2, CURRENT_TIMESTAMP),
       (0.30, 3, CURRENT_TIMESTAMP);

INSERT INTO carts (price, created_at, user_id)
VALUES (50.55, CURRENT_TIMESTAMP, 1),
       (10.99, CURRENT_TIMESTAMP, 2),
       (0.5, CURRENT_TIMESTAMP, 3);

INSERT INTO roles (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');