-- create this database if you dont have it
USE ski;

-- DROP TABLES
DROP TABLE IF EXISTS users;

-- CREATE TABLES
CREATE TABLE users
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    email     VARCHAR(50) UNIQUE                   NOT NULL,
    fullname     VARCHAR(50)                   NOT NULL,
    salt         VARCHAR(255)                         NOT NULL,
    passwordhash     VARCHAR(255)                         NOT NULL,
    role         ENUM ('Instructor', 'Student') NOT NULL,
    createdat TIMESTAMP                            NOT NULL DEFAULT CURRENT_TIMESTAMP,
    phone VARCHAR(20)
);

INSERT INTO users (email, fullname, salt, passwordhash, role) VALUES
                                                       ('ragaca@gmail.com','admin1', 'salt1', 'hashed_password1', 'Instructor'),
                                                       ('shragaca@gmail.com', 'user1', 'salt2', 'hashed_password2', 'Student'),
                                                       ('shrugaca@gmail.com', 'user2', 'salt3', 'hashed_password3', 'Instructor'),
                                                       ('shruguca@gmail.com',  'user3', 'salt4', 'hashed_password4', 'Student'),
                                                       ('shrugucu@gmail.com',  'user4', 'salt5', 'hashed_password5', 'Instructor');