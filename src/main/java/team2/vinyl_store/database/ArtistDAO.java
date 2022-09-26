package team2.vinyl_store.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team2.vinyl_store.Artist;

public class ArtistDAO implements DatabaseDAO<Artist> {

	public static final ArtistDAO DAO = new ArtistDAO();

	private ArtistDAO() {
	}

	@Override
	public boolean insert(Artist v) {
		String sql = "INSERT INTO artist(artistID,name) VALUES (?,?)";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return false;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, v.getArtistID());
			stmt.setString(2, v.getName());
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Artist v) {
		String sql = "UPDATE artist SET name = ? WHERE artistID = ?";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return false;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, v.getName());
			stmt.setInt(2, v.getArtistID());
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Artist v) {
		String sql = "DELETE FROM artist WHERE artistID = ?";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return false;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, v.getArtistID());
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Artist selectID(int id) {
		String sql = "SELECT * FROM artist WHERE artistID = ?";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return null;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			rs.next();
			Artist ret = new Artist(rs.getInt(1), rs.getString(2));
			stmt.close();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Artist> selectAll() {
		String sql = "SELECT * FROM artist";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return null;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();

			List<Artist> ret = new ArrayList<>();
			while (rs.next()) {
				ret.add(new Artist(rs.getInt(1), rs.getString(2)));
			}
			stmt.close();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
