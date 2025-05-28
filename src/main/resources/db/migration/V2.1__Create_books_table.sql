CREATE TABLE books(
    id serial,
    name varchar(255) NOT NULL,
    year_of_publication INT,
    author varchar(255),
    annotation TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    removed_at TIMESTAMP,
    created_user varchar(255),
    updated_user varchar(255),
    removed_user varchar(255),
    how_many_copies int,
    copies_available int,
    constraint pk_books primary key (id)
);