INSERT INTO artist(artist_id, name) VALUES(1, 'Queen');
INSERT INTO artist(artist_id, name) VALUES(2, 'Brockhampton');
INSERT INTO artist(artist_id, name) VALUES(3, 'Rico Nasty');
INSERT INTO artist(artist_id, name) VALUES(4, 'La Fouine');

INSERT INTO studio(studio_id, name) VALUES(1, 'Studio1');
INSERT INTO studio(studio_id, name) VALUES(2, 'Studio2');
INSERT INTO studio(studio_id, name) VALUES(3, 'Studio3');
INSERT INTO studio(studio_id, name) VALUES(4, 'Studio4');

INSERT INTO genre(genre_id, name) VALUES(1, 'Rap');
INSERT INTO genre(genre_id, name) VALUES(2, 'Classic Rock');

INSERT INTO vinyl(vinyl_id, title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES(1, 'Classic Queen', 1, 1, 1, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false);
INSERT INTO vinyl(vinyl_id, title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES(2, 'Ginger', 1, 1, 1, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false);
INSERT INTO vinyl(vinyl_id, title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES(3, 'XXI', 1, 1, 1, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false);
INSERT INTO vinyl(vinyl_id, title, genre_id, studio_id, artist_id, description, release_date, price_cents,
				cover_art_url, runtime, stock_quantity, times_ordered, is_explicit, is_archived)
				VALUES(4, 'Nightmare Vacation', 1, 1, 1, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false);

INSERT INTO category(category_id, name) VALUES(1, 'Best Selling');
INSERT INTO category(category_id, name) VALUES(2, 'Kids Hits');

INSERT INTO category_entry(category_entry_id, category_id, vinyl_id) VALUES (1, 1, 1);