INSERT INTO artist(name) VALUES('Queen');
INSERT INTO artist(name) VALUES('Brockhampton');
INSERT INTO artist(name) VALUES('Rico Nasty');
INSERT INTO artist(name) VALUES('La Fouine');

INSERT INTO studio(name) VALUES('EMI');
INSERT INTO studio(name) VALUES('Question Everything');
INSERT INTO studio(name) VALUES('Atlantic');
INSERT INTO studio(name) VALUES('Banlieue Sale');
INSERT INTO studio(name) VALUES('Hollywood');

INSERT INTO genre(name) VALUES('Rap');
INSERT INTO genre(name) VALUES('Classic Rock');

INSERT INTO vinyl(title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES('Classic Queen', 2, 1, 1, 'Tracks: A Kind of Magic, Bohemian Rhapsody, Under Pressure, Hammer to Fall, Stone Cold Crazy, One Year of Love, Radio Ga Ga, I''m Going Slightly Mad, I Want It All, Tie Your Mother Down, The Miracle, These Are the Days of Our Lives, One Vision, Keep Yourself Alive, Headlong, Who Wants to Live Forever, The Show Must Go On',
					'1992-03-03', 3599, '/assets/images/album_art/queen_sheer_heart_attack.webp', 4510, 10, 0, false, false);
INSERT INTO vinyl(title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES('Ginger', 1, 1, 2, 'Tracks: No Halo, Sugar, Boy Bye, Heaven Belongs to You, St. Percy, If You Pray Right, Dearly Departed, I Been Born Again, Ginger, Big Boy, Love Me for Life, Victor Roberts',
					'2019-08-23', 3599, '/assets/images/album_art/brockhampton_ginger.png', 2656, 1, 0, true, false);
INSERT INTO vinyl(title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES('Nightmare Vacation', 1, 1, 3, 'Tracks: Candy, Don''t Like Me, Check Me Out, iPhone, STFU, Back and Forth, Girl Scouts, Let It Out, Lose, No Debate, Pussy Poppin, OHFR?, 10Fo, Own It, Smack a Bitch (Remix), Smack a Bitch',
					'2020-12-04', 3599, '/assets/images/album_art/rico_nasty_nightmare_vacation.webp', 2666, 1, 0, true, false);
INSERT INTO vinyl(title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES('XXI', 1, 1, 4, 'Tracks: Rafale f3r, Millions, Monument, Avalanche, Euthanasie, Dans la zone, Sacoche, Goyard, Déracinés, Beretta, Bilet de 500, Poulet braisé, Pas le choix, Comment on fait, Laisse faire, Pardonne-moi',
					'2021-05-21', 3599, '/assets/images/album_art/la_fouine_xxi.jfif', 2666, 1, 0, true, false);
INSERT INTO vinyl(title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES('Queen', 2, 5, 1, 'Tracks: Keep Yourself Alive, Doing All Right, Great King Rat, My Fairy King, Liar, The Night Comes Down, Modern Times Rock ''n'' Roll, Son and Daughter, Jesus, Seven Seas of Rhye',
					'1973-07-13', 3599, '/assets/images/album_art/queen_queen.png', 2326, 10, 0, false, false);

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

