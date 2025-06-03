CREATE TABLE books (
    id serial,
    name varchar(255) NOT NULL,
    year_of_publication INT,
    author_id INTEGER,
    annotation TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    removed_at TIMESTAMP,
    created_user varchar(255),
    updated_user varchar(255),
    removed_user BIGINT REFERENCES users(id),
    constraint pk_books primary key (id)
);