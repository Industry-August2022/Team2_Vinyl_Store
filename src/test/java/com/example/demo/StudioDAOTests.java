package com.example.demo;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import team2.vinyl_store.Studio;
import team2.vinyl_store.database.DatabaseDAO;
import team2.vinyl_store.database.StudioDAO;

class StudioDAOTests {

	@BeforeEach
	void setupTable() {
		String sql = "DELETE FROM studio WHERE studioID > -1";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				fail("could not connect to database");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			stmt.execute("INSERT INTO studio(studioId, name) VALUES(1, 'Studio1')");
			stmt.execute("INSERT INTO studio(studioId, name) VALUES(2, 'Studio2')");
			stmt.execute("INSERT INTO studio(studioId, name) VALUES(3, 'Studio3')");
			stmt.execute("INSERT INTO studio(studioId, name) VALUES(4, 'Studio4')");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void insertSingle() {
		Studio studio = new Studio(5, "studio5");
		if (!StudioDAO.DAO.insert(studio))
			fail("failed to insert");
	}

	@Test
	void insertStudios() {
		Studio studio6 = new Studio(6, "studio6");
		Studio studio7 = new Studio(7, "studio7");
		Studio studio8 = new Studio(8, "studio8");
		if (!StudioDAO.DAO.insert(studio6))
			fail("failed to insert6");
		if (!StudioDAO.DAO.insert(studio7))
			fail("failed to insert7");
		if (!StudioDAO.DAO.insert(studio8))
			fail("failed to insert8");
	}

	@Test
	void selectID() {
		Studio studio = StudioDAO.DAO.selectID(1);
		System.out.println(studio);
	}

	@Test
	void selectAll() {
		List<Studio> all = StudioDAO.DAO.selectAll();
		for (Studio a : all)
			System.out.println(a);
	}

	@Test
	void deleteStudio9() {
		Studio studio = new Studio(9, "studio9");
		if (!StudioDAO.DAO.delete(studio))
			fail("failed to delete");
	}

	@Test
	void updateStudio8() {
		Studio studio = new Studio(8, "Studio8");
		if (!StudioDAO.DAO.update(studio))
			fail("failed to update");
	}

}
