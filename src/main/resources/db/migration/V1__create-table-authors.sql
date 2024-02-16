CREATE TABLE authors (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    birthdate DATE,
    deathdate DATE,

    PRIMARY KEY(id)
);