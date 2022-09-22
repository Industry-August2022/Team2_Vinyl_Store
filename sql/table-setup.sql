USE vinyl_store;

CREATE TABLE genre (
	genreId int NOT NULL,
    name varchar(32) NOT NULL,
    PRIMARY KEY(genreId)
);
CREATE TABLE studio (
	studioId int NOT NULL,
    name varchar(32) NOT NULL,
    PRIMARY KEY(studioId)
);
CREATE TABLE artist (
	artistId int NOT NULL,
    name varchar(32) NOT NULL,
    PRIMARY KEY(artistId)
);

CREATE TABLE user (
	userId int NOT NULL,
    address varchar(255) NOT NULL,
    username varchar(16) NOT NULL,
    password varchar(60) NOT NULL,
    paymentInfo varchar(60) NOT NULL,
    isAdmin boolean NOT NULL,
    PRIMARY KEY(userId)
);

CREATE TABLE vinyl (
	vinylId int NOT NULL,
    genreId int NOT NULL,
    studioId int NOT NULL,
    artistId int NOT NULL,
    title varchar(32) NOT NULL,
    description varchar(255) NOT NULL,
    releaseDate date NOT NULL,
    priceCents int NOT NULL,
    coverArtURL varchar(64),
    runtime int NOT NULL,
    stockQuantity int NOT NULL,
    timesOrdered int NOT NULL,
    isExplicit bool NOT NULL,
    isArchived bool NOT NULL,
    PRIMARY KEY(vinylId),
    FOREIGN KEY (genreId) REFERENCES genre(genreId)
		ON DELETE CASCADE,
    FOREIGN KEY (studioId) REFERENCES studio(studioId)
		ON DELETE CASCADE,
    FOREIGN KEY (artistId) REFERENCES artist(artistId)
		ON DELETE CASCADE
);
CREATE TABLE category (
	categoryId int NOT NULL,
    name varchar(32) NOT NULL,
    PRIMARY KEY(categoryId)
);
CREATE TABLE categoryEntry (
	categoryEntryId int NOT NULL,
	categoryId int NOT NULL,
	vinylId int NOT NULL,
    PRIMARY KEY(categoryEntryId),
    FOREIGN KEY (categoryId) REFERENCES category(categoryId)
		ON DELETE CASCADE,
    FOREIGN KEY (vinylId) REFERENCES vinyl(vinylId)
		ON DELETE CASCADE
);

CREATE TABLE orderInfo (
	orderId int NOT NULL,
    customerId int NOT NULL,
    datePlaced datetime NOT NULL,
    PRIMARY KEY(orderId),
    FOREIGN KEY (customerId) REFERENCES user(userId)
		ON DELETE CASCADE
);
CREATE TABLE orderEntry (
	orderEntryId int NOT NULL,
    orderId int NOT NULL,
    vinylId int NOT NULL,
    quantity int NOT NULL,
    PRIMARY KEY(orderEntryId),
    FOREIGN KEY (orderId) REFERENCES orderInfo(orderId)
		ON DELETE CASCADE,
    FOREIGN KEY (vinylId) REFERENCES vinyl(vinylId)
		ON DELETE CASCADE
);