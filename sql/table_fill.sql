INSERT INTO artist(name) VALUES('Queen');
INSERT INTO artist(name) VALUES('Brockhampton');
INSERT INTO artist(name) VALUES('Rico Nasty');
INSERT INTO artist(name) VALUES('La Fouine');

INSERT INTO studio(name) VALUES('Studio1');
INSERT INTO studio(name) VALUES('Studio2');
INSERT INTO studio(name) VALUES('Studio3');
INSERT INTO studio(name) VALUES('Studio4');

INSERT INTO genre(name) VALUES('Rap');
INSERT INTO genre(name) VALUES('Classic Rock');

INSERT INTO vinyl(title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES('Classic Queen', 2, 1, 1, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false);
INSERT INTO vinyl(title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES('Ginger', 1, 1, 2, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false);
INSERT INTO vinyl(title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES('XXI', 1, 1, 4, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false);
INSERT INTO vinyl(title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES('Nightmare Vacation', 1, 1, 3, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false);
INSERT INTO vinyl(title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES('Queen', 2, 1, 1, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false);

INSERT INTO category(name) VALUES('Best Selling');
INSERT INTO category(name) VALUES('Kids Hits');

INSERT INTO category_entry(category_id, vinyl_id) VALUES (1, 1);

INSERT INTO user(address, username, password, payment_info, is_admin) VALUES ("123 Fake St, Atlanta, GA 30309", "fake.email@example.com", "hashedpassword1", "CARD INFO", false);
INSERT INTO user(address, username, password, payment_info, is_admin) VALUES ("42 Hilda Blvd, Atlanta, GA 30309", "hilda@example.com", "hashedpassword1", "CARD INFO", false);
INSERT INTO user(address, username, password, payment_info, is_admin) VALUES ("Myles Address, Atlanta, GA 30309", "myles@example.com", "hashedpassword1", "CARD INFO", true);
INSERT INTO user(address, username, password, payment_info, is_admin) VALUES ("Destiny Address, Atlanta, GA 30309", "destiny@example.com", "hashedpassword1", "CARD INFO", true);
INSERT INTO user(address, username, password, payment_info, is_admin) VALUES ("Amadou Address, Atlanta, GA 30309", "amadou@example.com", "hashedpassword1", "CARD INFO", true);
INSERT INTO user(address, username, password, payment_info, is_admin) VALUES ("Bruce Address, Atlanta, GA 30309", "bruce@example.com", "hashedpassword1", "CARD INFO", true);

INSERT INTO order_info(customer_id, date_placed) VALUES (1, CURRENT_DATE());
INSERT INTO order_info(customer_id, date_placed) VALUES (1, CURRENT_DATE());
INSERT INTO order_info(customer_id, date_placed) VALUES (1, CURRENT_DATE());

INSERT INTO order_entry(order_id, vinyl_id, quantity) VALUES (1, 1, 5);
INSERT INTO order_entry(order_id, vinyl_id, quantity) VALUES (1, 2, 1);

INSERT INTO cart(customer_id) VALUES (1);
INSERT INTO cart_content(cart_id, vinyl_id, quantity) VALUES (1, 1, 5);
INSERT INTO cart_content(cart_id, vinyl_id, quantity) VALUES (1, 2, 3);

INSERT INTO cart(customer_id) VALUES (3);
INSERT INTO cart_content(cart_id, vinyl_id, quantity) VALUES (2, 1, 50);

