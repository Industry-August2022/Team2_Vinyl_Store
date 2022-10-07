INSERT INTO artist(artist_id, name) VALUES(1, 'Queen');
INSERT INTO artist(artist_id, name) VALUES(2, 'Brockhampton');
INSERT INTO artist(artist_id, name) VALUES(3, 'Rico Nasty');
INSERT INTO artist(artist_id, name) VALUES(4, 'La Fouine');
INSERT INTO artist(artist_id, name) VALUES(5, 'Eminem');

	INSERT INTO studio(studio_id, name) VALUES(1, 'Studio1');
	INSERT INTO studio(studio_id, name) VALUES(2, 'Studio2');
	INSERT INTO studio(studio_id, name) VALUES(3, 'Studio3');
	INSERT INTO studio(studio_id, name) VALUES(4, 'Studio4');
	INSERT INTO studio(studio_id, name) VALUES(5, 'Studio5');

INSERT INTO genre(genre_id, name) VALUES(1, 'Rap');
INSERT INTO genre(genre_id, name) VALUES(2, 'Classic Rock');
INSERT INTO genre(genre_id, name) VALUES(3, 'Jazz');
INSERT INTO genre(genre_id, name) VALUES(4, 'Blues');
INSERT INTO genre(genre_id, name) VALUES(5, 'Country Music');

INSERT INTO vinyl(vinyl_id, genre_id, studio_id, artist_id, title, description, release_date, price_cents, cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived) VALUES (1, 1, 1, 1, "title1", "description1", "2001-01-01", 111, "www.111.com", 111, 111, 111, true, false);
INSERT INTO vinyl(vinyl_id, genre_id, studio_id, artist_id, title, description, release_date, price_cents, cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived) VALUES (2, 2, 2, 2, "title2", "description2", "2002-02-02", 222, "www.222.com", 222, 222, 222, true, false);
INSERT INTO vinyl(vinyl_id, genre_id, studio_id, artist_id, title, description, release_date, price_cents, cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived) VALUES (3, 3, 3, 3, "title3", "description3", "2003-03-03", 333, "www.333.com", 333, 333, 333, true, false);
INSERT INTO vinyl(vinyl_id, genre_id, studio_id, artist_id, title, description, release_date, price_cents, cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived) VALUES (4, 4, 4, 4, "title4", "description4", "2004-04-04", 444, "www.444.com", 444, 444, 444, true, false);


INSERT INTO user(user_id, address, username, password, payment_info, is_admin) VALUES(1, '101 Main St, Atlanta, GA', 'username1', 'password1', '1111 1111 1111 1111', false);
INSERT INTO user(user_id, address, username, password, payment_info, is_admin) VALUES(2, '102 Main St, Atlanta, GA', 'username2', 'password2', '2222 2222 2222 2222', true);
INSERT INTO user(user_id, address, username, password, payment_info, is_admin) VALUES(3, '103 Main St, Atlanta, GA', 'username3', 'password3', '3333 3333 3333 3333', false);
INSERT INTO user(user_id, address, username, password, payment_info, is_admin) VALUES(4, '104 Main St, Atlanta, GA', 'username4', 'password4', '4444 4444 4444 4444', true);

INSERT INTO vinyl(vinyl_id, title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES(1, 'Classic Queen', 2, 1, 1, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false);
INSERT INTO vinyl(vinyl_id, title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES(2, 'Ginger', 1, 1, 2, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false);
INSERT INTO vinyl(vinyl_id, title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES(3, 'XXI', 1, 1, 4, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false);
INSERT INTO vinyl(vinyl_id, title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES(4, 'Nightmare Vacation', 1, 1, 3, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false);
INSERT INTO vinyl(vinyl_id, title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES(5, 'Queen', 2, 1, 1, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false);

INSERT INTO category(category_id, name) VALUES(1, 'Best Selling');
INSERT INTO category(category_id, name) VALUES(2, 'Kids Hits');

INSERT INTO category_entry(category_entry_id, category_id, vinyl_id) VALUES (1, 1, 1);