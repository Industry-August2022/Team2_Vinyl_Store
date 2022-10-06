USE vinyl_store;

CREATE TABLE genre (
	genre_id int NOT NULL AUTO_INCREMENT,
    name varchar(32) NOT NULL,
    PRIMARY KEY(genre_id)
);
CREATE TABLE studio (
	studio_id int NOT NULL AUTO_INCREMENT,
    name varchar(32) NOT NULL,
    PRIMARY KEY(studio_id)
);
CREATE TABLE artist (
	artist_id int NOT NULL AUTO_INCREMENT,
    name varchar(32) NOT NULL,
    PRIMARY KEY(artist_id)
);

CREATE TABLE user (
	user_id int NOT NULL AUTO_INCREMENT,
    address varchar(255) NOT NULL,
    username varchar(16) NOT NULL,
    password varchar(60) NOT NULL,
    payment_info varchar(60) NOT NULL,
    is_admin boolean NOT NULL,
    PRIMARY KEY(user_id)
);

CREATE TABLE vinyl (
	vinyl_id int NOT NULL AUTO_INCREMENT,
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
	category_id int NOT NULL AUTO_INCREMENT,
    name varchar(32) NOT NULL,
    PRIMARY KEY(category_id)
);
CREATE TABLE category_entry (
	category_entry_id int NOT NULL AUTO_INCREMENT,
	category_id int NOT NULL,
	vinyl_id int NOT NULL,
    PRIMARY KEY(category_entry_id),
    FOREIGN KEY (category_id) REFERENCES category(category_id)
		ON DELETE CASCADE,
    FOREIGN KEY (vinyl_id) REFERENCES vinyl(vinyl_id)
		ON DELETE CASCADE
);

CREATE TABLE order_info (
	order_info_id int NOT NULL AUTO_INCREMENT,
    customer_id int NOT NULL,
    date_placed datetime NOT NULL,
    PRIMARY KEY(order_info_id),
    FOREIGN KEY (customer_id) REFERENCES user(user_id)
		ON DELETE CASCADE
);
CREATE TABLE order_entry (
	order_entry_id int NOT NULL AUTO_INCREMENT,
    order_id int NOT NULL,
    vinyl_id int NOT NULL,
    quantity int NOT NULL,
    PRIMARY KEY(order_entry_id),
    FOREIGN KEY (order_id) REFERENCES order_info(order_info_id)
		ON DELETE CASCADE,
    FOREIGN KEY (vinyl_id) REFERENCES vinyl(vinyl_id)
		ON DELETE CASCADE
);

CREATE TABLE SPRING_SESSION (
  PRIMARY_ID CHAR(36) NOT NULL,
  SESSION_ID CHAR(36) NOT NULL,
  CREATION_TIME BIGINT NOT NULL,
  LAST_ACCESS_TIME BIGINT NOT NULL,
  MAX_INACTIVE_INTERVAL INT NOT NULL,
  EXPIRY_TIME BIGINT NOT NULL,
  PRINCIPAL_NAME VARCHAR(100),
  CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
);
 
CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);
 
CREATE TABLE SPRING_SESSION_ATTRIBUTES (
  SESSION_PRIMARY_ID CHAR(36) NOT NULL,
  ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
  ATTRIBUTE_BYTES LONG VARBINARY NOT NULL,
  CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
  CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
);
 
CREATE INDEX SPRING_SESSION_ATTRIBUTES_IX1 ON SPRING_SESSION_ATTRIBUTES (SESSION_PRIMARY_ID);