DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (
    id SERIAL NOT NULL PRIMARY KEY,
    username char(50) NOT NULL,
    password char(60) NOT NULL,
    full_name char(50) NOT NULL,
    address char(50) NOT NULL,
    email char(50) NOT NULL,
    role char(50) NOT NULL);