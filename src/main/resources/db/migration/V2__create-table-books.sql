CREATE TABLE books (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    authorid BIGINT(20) NOT NULL,
    summary VARCHAR(1000) NOT NULL,
    isbn VARCHAR(100) NOT NULL,
    genreid BIGINT(20),

    PRIMARY KEY(id),
  	FOREIGN KEY (authorid) REFERENCES authors(id)
);