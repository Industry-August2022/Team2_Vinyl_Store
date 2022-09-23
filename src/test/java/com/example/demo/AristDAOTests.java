package com.example.demo;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import team2.vinyl_store.Artist;
import team2.vinyl_store.Category;
import team2.vinyl_store.database.ArtistDAO;
import team2.vinyl_store.database.CategoryDAO;
import team2.vinyl_store.database.DatabaseDAO;

class AristDAOTests {

	@BeforeEach
	void setupTable() {
		String sql = "DELETE FROM artist WHERE artistID > -1";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				fail("could not connect to database");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			stmt.execute("INSERT INTO artist(artistID, name) VALUES(1, 'Queen')");
			stmt.execute("INSERT INTO artist(artistID, name) VALUES(2, 'BrockhamptonERR')");
			stmt.execute("INSERT INTO artist(artistID, name) VALUES(3, 'Rico Nasty')");
			stmt.execute("INSERT INTO artist(artistID, name) VALUES(4, 'La Fouine')");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void insertSingle() {
		Artist artist = new Artist(5, "Journey");
		if (!ArtistDAO.DAO.insert(artist))
			fail("failed to insert");
	}

	@Test
	void insertThree() {
		Artist artist2 = new Artist(6, "Foreigner");
		Artist artist3 = new Artist(7, "Billy Joel");
		Artist artist4 = new Artist(8, "Dallas String Quartet");
		if (!ArtistDAO.DAO.insert(artist2))
			fail("failed to insert2");
		if (!ArtistDAO.DAO.insert(artist3))
			fail("failed to insert3");
		if (!ArtistDAO.DAO.insert(artist4))
			fail("failed to insert4");
	}

	@Test
	void selectID() {
		Category all = CategoryDAO.DAO.selectID(1);
		System.out.println(all);
	}

	@Test
	void selectAll() {
		List<Artist> all = ArtistDAO.DAO.selectAll();
		for (Artist a : all)
			System.out.println(a);
	}

	@Test
	void deleteQueen() {
		Artist artist = new Artist(1, "Queen");
		if (!ArtistDAO.DAO.delete(artist))
			fail("failed to delete");
	}

	@Test
	void updateBrockhampton() {
		Artist artist = new Artist(2, "Brockhampton");
		if (!ArtistDAO.DAO.update(artist))
			fail("failed to update");
	}

}
