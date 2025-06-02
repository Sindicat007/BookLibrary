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
    created_user bigint REFERENCES users(id),
    removed_user bigint REFERENCES users(id),
    CONSTRAINT pk_user PRIMARY KEY (id)
);