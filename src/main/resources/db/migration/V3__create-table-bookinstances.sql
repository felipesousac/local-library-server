CREATE TABLE bookinstances (
    bookid BIGINT(20) NOT NULL,
    imprint VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    dueback DATE,

 	FOREIGN KEY (bookid) REFERENCES books(id)
);