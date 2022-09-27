package com.example.demo;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import team2.vinyl_store.Vinyl;
import team2.vinyl_store.database.DatabaseDAO;
import team2.vinyl_store.database.VinylDAO;

public class VinylDAOTests {
	@BeforeEach
	void setupTable() {
		String sql = "DELETE FROM vinyl WHERE vinylId > -1";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				fail("could not connect to database");
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.executeUpdate();
			stmt.executeUpdate("DELETE FROM artist WHERE artistID > -1");
			stmt.executeUpdate("DELETE FROM studio WHERE studioID > -1");
			stmt.executeUpdate("DELETE FROM genre WHERE genreID > -1");
			
			
			
			for (int i = 0; i <= 10; i++) {
				stmt.execute("insert into genre (genreId, name) values ("+(200 + i)+", 'Genre_"+(1 + i)+"')");
				stmt.execute("insert into studio (studioId, name) values ("+(300 + i)+", 'Studio_"+(1 + i)+"')");
				stmt.execute("insert into artist (artistId, name) values ("+(400 + i)+", 'Artist_"+(1 + i)+"')");
			}
	
			stmt.execute("INSERT INTO vinyl(vinylID, genreID, studioID, artistID, title, description, releaseDate, priceCents, coverArtURL, runtime, stockQuantity, timesOrdered, isExplicit, isArchived) VALUES(1,200,300,400,'Title_1', 'Description_1','1990-01-01',500,'www.google.com',600,700,800,true,false)");
			stmt.execute("INSERT INTO vinyl(vinylID, genreID, studioID, artistID, title, description, releaseDate, priceCents, coverArtURL, runtime, stockQuantity, timesOrdered, isExplicit, isArchived) VALUES(2,201,301,401,'Title_2', 'Description_2','1990-02-02',501,'www.cognizant.com',601,701,801,false,true)");
			stmt.execute("INSERT INTO vinyl(vinylID, genreID, studioID, artistID, title, description, releaseDate, priceCents, coverArtURL, runtime, stockQuantity, timesOrdered, isExplicit, isArchived) VALUES(3,202,302,402,'Title_3', 'Description_3','1990-03-03',502,'www.linkedin.com',602,702,802,true,false)");
			stmt.execute("INSERT INTO vinyl(vinylID, genreID, studioID, artistID, title, description, releaseDate, priceCents, coverArtURL, runtime, stockQuantity, timesOrdered, isExplicit, isArchived) VALUES(4,203,303,403,'Title_4', 'Description_4','1990-04-04',503,'www.amazon.com',603,703,803,false,true)");
			System.out.println("All inserted");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void insertSingle() {
		
		
		Vinyl vinyl = new Vinyl(5,204,304,404,"Title_5", "Description_5","1990-04-04",504,"www.microsoft.com",604,704,804,true,false);
		if (!VinylDAO.DAO.insert(vinyl))
			fail("failed to insert");
	}

	@Test
	void insertVinyl() {
		
		Vinyl vinyl6 = new Vinyl(6,205,305,405,"Title_6", "Description_6","1990-04-04",505,"www.microsoft.com",605,705,805,true,false);
		Vinyl vinyl7 = new Vinyl(7,206,306,406,"Title_7", "Description_7","1990-04-04",506,"www.microsoft.com",606,706,806,true,false);
		Vinyl vinyl8 = new Vinyl(8,207,307,407,"Title_8", "Description_8","1990-04-04",507,"www.microsoft.com",607,707,807,true,false);

		if (!VinylDAO.DAO.insert(vinyl6))
			fail("failed to insert6");
		if (!VinylDAO.DAO.insert(vinyl7))
			fail("failed to insert7");
		if (!VinylDAO.DAO.insert(vinyl8))
			fail("failed to insert8");
		
		selectAll();
	}

	@Test
	void selectID() {
		Vinyl vinyl = VinylDAO.DAO.selectID(1);
		System.out.println(vinyl);
	}

	@Test
	void selectAll() {
		List<Vinyl> all = VinylDAO.DAO.selectAll();
		for (Vinyl a : all)
			System.out.println(a);
	}

	@Test
	void deleteStudio() {
		Vinyl vinyl = new Vinyl(2,208,308,408,"Title_9", "Description_9","1990-04-04",508,"www.microsoft.com",608,708,808,true,false);
		if (!VinylDAO.DAO.delete(vinyl))
			fail("failed to delete");
	}

	@Test
	void updateVinyl8() {
		Vinyl vinyl = new Vinyl(4,209,309,409,"Title_10", "Description_10","1990-04-04",509,"www.microsoft.com",609,709,809,true,false);
		if (!VinylDAO.DAO.update(vinyl))
			fail("failed to update");
		System.out.println("location of SelectAll method");
		selectAll();
	}
}
