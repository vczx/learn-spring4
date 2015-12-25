--DROP TABLE users IF EXISTS;

CREATE TABLE books (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  isbn  VARCHAR(50)
);
