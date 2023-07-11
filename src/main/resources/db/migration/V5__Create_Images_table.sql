-- Creating junction table images
--
CREATE TABLE IF NOT EXISTS images
(
    image_id INTEGER NOT NULL,
    link     VARCHAR(50) UNIQUE,
    CONSTRAINT pk_images PRIMARY KEY (image_id)
);
