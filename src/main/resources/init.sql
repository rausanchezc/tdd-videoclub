CREATE TABLE film (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(80) NOT NULL,
    rating DECIMAL(4,2) UNSIGNED NOT NULL,
    PRIMARY KEY (`id`)
);


INSERT INTO (title, rating) film VALUES ('Klaus', 9.8), ('Coco', 8.9);