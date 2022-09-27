package team2.vinyl_store.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import team2.vinyl_store.Vinyl;

public class VinylDAO implements DatabaseDAO<Vinyl> {

	public static final VinylDAO DAO = new VinylDAO();
	
	@Override
	public boolean insert(Vinyl v) {
		String sql = "INSERT INTO vinyl(vinylID, genreID, studioID, artistID, title, description, releaseDate, priceCents, coverArtURL, runtime, stockQuantity, timesOrdered, isExplicit, isArchived) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return false;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, v.getVinylID());
			stmt.setInt(2, v.getGenreID());
			stmt.setInt(3, v.getStudioID());
			stmt.setInt(4, v.getArtistID());
			stmt.setString(5, v.getTitle());
			stmt.setString(6, v.getDescription());
			stmt.setString(7, v.getReleaseDate());
			stmt.setInt(8, v.getPriceCents());
			stmt.setString(9, v.getCoverArtURL());
			stmt.setInt(10, v.getRuntime());
			stmt.setInt(11, v.getStockQuantity());
			stmt.setInt(12, v.getTimesOrdered());
			stmt.setBoolean(13, v.isExplicit());
			stmt.setBoolean(14, v.isArchived());
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Vinyl v) {
		String sql = "UPDATE vinyl SET genreID = ?, studioID = ?, artistID = ?, title = ?, description = ?, releaseDate = ?, priceCents = ?, coverArtURL = ?, runtime = ?, stockQuantity = ?, timesOrdered = ?, isExplicit = ?, isArchived = ? WHERE vinylID = ?;";
		
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return false;
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, v.getGenreID());
			stmt.setInt(2, v.getStudioID());
			stmt.setInt(3, v.getArtistID());
			stmt.setString(4, v.getTitle());
			stmt.setString(5, v.getDescription());
			stmt.setString(6, v.getReleaseDate());
			stmt.setInt(7, v.getPriceCents());
			stmt.setString(8, v.getCoverArtURL());
			stmt.setInt(9, v.getRuntime());
			stmt.setInt(10, v.getStockQuantity());
			stmt.setInt(11, v.getTimesOrdered());
			stmt.setBoolean(12, v.isExplicit());
			stmt.setBoolean(13, v.isArchived());
			stmt.setInt(14, v.getVinylID());
			
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean delete(Vinyl v) {
		
		String sql = "DELETE FROM vinyl WHERE vinylID = ?";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return false;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, v.getVinylID());
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Vinyl selectID(int id) {

		String sql = "SELECT * FROM vinyl WHERE studioID = ?";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return null;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			Vinyl ret = new Vinyl(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getBoolean(13), rs.getBoolean(14));
			stmt.close();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Vinyl> selectAll() {
		
		String sql = "SELECT * FROM vinyl";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return null;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();

			List<Vinyl> ret = new ArrayList<>();
			while (rs.next()) {
				ret.add(new Vinyl(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getBoolean(13), rs.getBoolean(14)));
			}
			stmt.close();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
