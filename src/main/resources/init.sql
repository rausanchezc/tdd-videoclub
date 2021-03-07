CREATE TABLE film (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(80) NOT NULL,
    rating DECIMAL(4,2) UNSIGNED NOT NULL,
    PRIMARY KEY (`id`)
);


INSERT INTO film (title, rating)  VALUES ('Coco', 8.9), ('Klaus', 9.8);