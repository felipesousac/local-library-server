ALTER TABLE books
ADD FOREIGN KEY (genreid) REFERENCES genres(id)
;