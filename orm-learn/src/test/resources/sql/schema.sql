--DROP TABLE users IF EXISTS;

CREATE TABLE book (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  isbn  VARCHAR(50)
);
