package com.example.demo;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import team2.vinyl_store.Category;
import team2.vinyl_store.Genre;
import team2.vinyl_store.database.GenreDAO;
import team2.vinyl_store.database.CategoryDAO;
import team2.vinyl_store.database.DatabaseDAO;

class GenreDAOTests {

	@BeforeEach
	void setupTable() {
		String sql = "DELETE FROM genre WHERE genreID > -1";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				fail("could not connect to database");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			stmt.execute("INSERT INTO genre(genreID, name) VALUES(1, 'Rap')");
			stmt.execute("INSERT INTO genre(genreID, name) VALUES(2, 'Classic RockERR')");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void insertSingle() {
		Genre genre = new Genre(5, "Pop");
		if (!GenreDAO.DAO.insert(genre))
			fail("failed to insert");
	}

	@Test
	void insertThree() {
		Genre genre2 = new Genre(6, "Classical");
		Genre genre3 = new Genre(7, "Rock");
		Genre genre4 = new Genre(8, "Musicals");
		if (!GenreDAO.DAO.insert(genre2))
			fail("failed to insert2");
		if (!GenreDAO.DAO.insert(genre3))
			fail("failed to insert3");
		if (!GenreDAO.DAO.insert(genre4))
			fail("failed to insert4");
	}

	@Test
	void selectID() {
		Category all = CategoryDAO.DAO.selectID(1);
		System.out.println(all);
	}

	@Test
	void selectAll() {
		List<Genre> all = GenreDAO.DAO.selectAll();
		for (Genre a : all)
			System.out.println(a);
	}

	@Test
	void deleteRap() {
		Genre genre = new Genre(1, "Rap");
		if (!GenreDAO.DAO.delete(genre))
			fail("failed to delete");
	}

	@Test
	void updateRock() {
		Genre genre = new Genre(2, "Rock");
		if (!GenreDAO.DAO.update(genre))
			fail("failed to update");
	}

}
