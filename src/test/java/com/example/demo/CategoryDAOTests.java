package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import team2.vinyl_store.Category;
import team2.vinyl_store.database.CategoryDAO;
import team2.vinyl_store.database.DatabaseDAO;

class CategoryDAOTests {

	@BeforeEach
	void setupTable() {
		String sql = "DELETE FROM category WHERE categoryID > -1";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				fail("could not connect to database");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			stmt.executeUpdate("DELETE FROM categoryEntry WHERE categoryEntryID > -1");
			stmt.executeUpdate("DELETE FROM artist WHERE artistID > -1");
			stmt.executeUpdate("DELETE FROM studio WHERE studioID > -1");
			stmt.executeUpdate("DELETE FROM genre WHERE genreID > -1");

			stmt.execute("INSERT INTO category(categoryID, name) VALUES(1, 'Best Selling')");
			stmt.execute("INSERT INTO category(categoryID, name) VALUES(2, 'Kids HitsERR')");

			stmt.execute("INSERT INTO genre(genreID, name) VALUES(1, 'Classic Rock')");
			stmt.execute("INSERT INTO studio(studioID, name) VALUES(1, 'QueenStudio')");
			stmt.execute("INSERT INTO artist(artistID, name) VALUES(1, 'Queen')");

			stmt.execute(
					"INSERT INTO vinyl(vinylID, title, genreID, studioID, artistID, description, releaseDate, priceCents, "
							+ "coverArtURL, runtime, stockQuantity, timesOrdered, isExplicit, isArchived) "
							+ "VALUES(1, 'Classic Queen', 1, 1, 1, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false)");
			stmt.execute(
					"INSERT INTO vinyl(vinylID, title, genreID, studioID, artistID, description, releaseDate, priceCents, "
							+ "coverArtURL, runtime, stockQuantity, timesOrdered, isExplicit, isArchived) "
							+ "VALUES(2, 'Ginger', 1, 1, 1, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false)");
			stmt.execute(
					"INSERT INTO vinyl(vinylID, title, genreID, studioID, artistID, description, releaseDate, priceCents, "
							+ "coverArtURL, runtime, stockQuantity, timesOrdered, isExplicit, isArchived) "
							+ "VALUES(3, 'XXI', 1, 1, 1, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false)");
			stmt.execute(
					"INSERT INTO vinyl(vinylID, title, genreID, studioID, artistID, description, releaseDate, priceCents, "
							+ "coverArtURL, runtime, stockQuantity, timesOrdered, isExplicit, isArchived) "
							+ "VALUES(4, 'Nightmare Vacation', 1, 1, 1, 'Desc', '1999-01-01', 100, '', 60, 1, 0, false, false)");
			
			stmt.execute("INSERT INTO categoryEntry(categoryEntryID, categoryID, vinylID) VALUES (1, 1, 1)");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void insertSingle() {
		Category category = new Category(5, "Latest Releases");
		category.addVinyl(1);
		if (!CategoryDAO.DAO.insert(category))
			fail("failed to insert");
	}

	@Test
	void insertThree() {
		Category category2 = new Category(6, "TestCat6");
		Category category3 = new Category(7, "TestCat7");
		Category category4 = new Category(8, "TestCat8");
		if (!CategoryDAO.DAO.insert(category2))
			fail("failed to insert2");
		if (!CategoryDAO.DAO.insert(category3))
			fail("failed to insert3");
		if (!CategoryDAO.DAO.insert(category4))
			fail("failed to insert4");
	}

	@Test
	void selectID() {
		Category category = CategoryDAO.DAO.selectID(1);
		System.out.println(category);
		assertEquals(1, category.getVinyl().size());
	}

	@Test
	void selectAll() {
		List<Category> all = CategoryDAO.DAO.selectAll();
		for (Category a : all)
			System.out.println(a);
		assertEquals(1, all.get(0).getVinyl().size());
		assertEquals(0, all.get(1).getVinyl().size());
	}

	@Test
	void deleteBestSelling() {
		Category category = new Category(1, "Best Selling");
		assertTrue(CategoryDAO.DAO.delete(category));
	}

	@Test
	void updateKidsHits() {
		Category category = new Category(2, "Kids Hits");
		assertTrue(CategoryDAO.DAO.update(category));
	}

}
