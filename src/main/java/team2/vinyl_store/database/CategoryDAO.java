package team2.vinyl_store.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team2.vinyl_store.Category;

public class CategoryDAO implements DatabaseDAO<Category> {

	public static final CategoryDAO DAO = new CategoryDAO();

	private CategoryDAO() {
	}

	private int getMaxEntryID() {
		String sql = "SELECT MAX(categoryEntryID) FROM categoryEntry";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return -1;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			rs.next();
			int max = rs.getInt(1);
			stmt.close();
			return max;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public boolean insert(Category v) {
		String sql = "INSERT INTO category(categoryID,name) VALUES (?,?)";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return false;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, v.getCategoryID());
			stmt.setString(2, v.getName());
			stmt.executeUpdate();
			stmt.close();
			insertCategoryEntries(conn, v);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean insertCategoryEntries(Connection conn, Category v) {
		String sql = "INSERT INTO categoryEntry(categoryEntryID,categoryID,vinylID) VALUES (?,?,?)";
		try {
			for (Integer vinylID : v.getVinyl()) {
				int nextID = getMaxEntryID();
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, nextID + 1);
				stmt.setInt(2, v.getCategoryID());
				stmt.setInt(3, vinylID);
				stmt.executeUpdate();
				stmt.close();
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Category v) {
		String sql = "UPDATE category SET name = ? WHERE categoryID = ?";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return false;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, v.getName());
			stmt.setInt(2, v.getCategoryID());
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Category v) {
		String sql = "DELETE FROM category WHERE categoryID = ?";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return false;
			if (!deleteCategoryEntries(conn, v))
				return false;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, v.getCategoryID());
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean deleteCategoryEntries(Connection conn, Category v) {
		String sql = "DELETE FROM categoryEntry WHERE categoryID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, v.getCategoryID());
			stmt.executeUpdate();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Category selectID(int id) {
		String sql = "SELECT * FROM category WHERE categoryID = ?";
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
			List<Integer> vinyl = getCategoryEntries(conn, id);
			Category ret = new Category(rs.getInt(1), rs.getString(2), vinyl);
			
			stmt.close();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private List<Integer> getCategoryEntries(Connection conn, int categoryID) {
		String sql = "SELECT vinylID FROM categoryEntry WHERE categoryID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, categoryID);
			stmt.execute();
			
			ResultSet rs = stmt.getResultSet();
			List<Integer> ret = new ArrayList<>();
			while(rs.next())
				ret.add(rs.getInt(1));
			stmt.close();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> selectAll() {
		String sql = "SELECT * FROM category";
		Connection conn;
		try {
			conn = DriverManager.getConnection(DatabaseDAO.DBURL, DatabaseDAO.USER, DatabaseDAO.PASS);
			if (conn == null)
				return null;
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();

			List<Category> ret = new ArrayList<>();
			while (rs.next()) {
				int categoryID = rs.getInt(1);
				List<Integer> vinyl = getCategoryEntries(conn, categoryID);
				ret.add(new Category(categoryID, rs.getString(2), vinyl));
			}
			stmt.close();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
