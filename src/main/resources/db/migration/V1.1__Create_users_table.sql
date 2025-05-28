CREATE TABLE users (
    id serial,
    username VARCHAR(255) NOT NULL,
    age INT,
    email VARCHAR(255),
    phone_number VARCHAR(255),
    password VARCHAR(255),
    roles VARCHAR(255),
    created_at TIMESTAMP,
    removed_at TIMESTAMP,
    created_user VARCHAR(255),
    removed_user VARCHAR(255),
    CONSTRAINT pk_user PRIMARY KEY (id)
);