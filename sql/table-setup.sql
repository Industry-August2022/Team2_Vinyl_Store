USE vinyl_store;

CREATE TABLE genre (
	genre_id int NOT NULL,
    name varchar(32) NOT NULL,
    PRIMARY KEY(genre_id)
);
CREATE TABLE studio (
	studio_id int NOT NULL,
    name varchar(32) NOT NULL,
    PRIMARY KEY(studio_id)
);
CREATE TABLE artist (
	artist_id int NOT NULL,
    name varchar(32) NOT NULL,
    PRIMARY KEY(artist_id)
);

CREATE TABLE user (
	user_id int NOT NULL,
    address varchar(255) NOT NULL,
    username varchar(16) NOT NULL,
    password varchar(60) NOT NULL,
    payment_info varchar(60) NOT NULL,
    is_admin boolean NOT NULL,
    PRIMARY KEY(user_id)
);

CREATE TABLE vinyl (
	vinyl_id int NOT NULL,
    genre_id int NOT NULL,
    studio_id int NOT NULL,
    artist_id int NOT NULL,
    title varchar(32) NOT NULL,
    description varchar(255) NOT NULL,
    release_date date NOT NULL,
    price_cents int NOT NULL,
    cover_art_url varchar(64),
    runtime int NOT NULL,
    stock_quantity int NOT NULL,
    times_ordered int NOT NULL,
    is_explicit bool NOT NULL,
    is_archived bool NOT NULL,
    PRIMARY KEY(vinyl_id),
    FOREIGN KEY (genre_id) REFERENCES genre(genre_id)
		ON DELETE CASCADE,
    FOREIGN KEY (studio_id) REFERENCES studio(studio_id)
		ON DELETE CASCADE,
    FOREIGN KEY (artist_id) REFERENCES artist(artist_id)
		ON DELETE CASCADE
);
CREATE TABLE category (
	category_id int NOT NULL,
    name varchar(32) NOT NULL,
    PRIMARY KEY(category_id)
);
CREATE TABLE category_entry (
	category_entry_id int NOT NULL,
	category_id int NOT NULL,
	vinyl_id int NOT NULL,
    PRIMARY KEY(category_entry_id),
    FOREIGN KEY (category_id) REFERENCES category(category_id)
		ON DELETE CASCADE,
    FOREIGN KEY (vinyl_id) REFERENCES vinyl(vinyl_id)
		ON DELETE CASCADE
);

CREATE TABLE order_info (
	order_id int NOT NULL,
    customer_id int NOT NULL,
    date_placed datetime NOT NULL,
    PRIMARY KEY(order_id),
    FOREIGN KEY (customer_id) REFERENCES user(user_id)
		ON DELETE CASCADE
);
CREATE TABLE order_entry (
	order_entry_id int NOT NULL,
    order_id int NOT NULL,
    vinyl_id int NOT NULL,
    quantity int NOT NULL,
    PRIMARY KEY(order_entry_id),
    FOREIGN KEY (order_id) REFERENCES order_info(order_id)
		ON DELETE CASCADE,
    FOREIGN KEY (vinyl_id) REFERENCES vinyl(vinyl_id)
		ON DELETE CASCADE
);