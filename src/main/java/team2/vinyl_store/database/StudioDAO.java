package team2.vinyl_store.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import team2.vinyl_store.Studio;

public class StudioDAO implements DatabaseDAO<Studio> {
	
	public static final StudioDAO DAO = new StudioDAO();

	@Override
	public boolean insert(Studio v) {
		String sql = "INSERT INTO studio(studioId,name) VALUES (?,?)";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return false;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, v.getStudioID());
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
	public boolean update(Studio v) {
		
		String sql = "UPDATE studio SET name = ? WHERE studioId = ?";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return false;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, v.getName());
			stmt.setInt(2, v.getStudioID());
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(Studio v) {
		
		String sql = "DELETE FROM studio WHERE studioID = ?";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return false;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, v.getStudioID());
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Studio selectID(int id) {
		
		String sql = "SELECT * FROM studio WHERE studioID = ?";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return null;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			Studio ret = new Studio(rs.getInt(1), rs.getString(2));
			stmt.close();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Studio> selectAll() {

		String sql = "SELECT * FROM studio";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return null;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();

			List<Studio> ret = new ArrayList<>();
			while (rs.next()) {
				ret.add(new Studio(rs.getInt(1), rs.getString(2)));
			}
			stmt.close();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
