package team2.vinyl_store.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import team2.vinyl_store.Category;

public class CategoryDAO implements DatabaseDAO<Category> {

	@Override
	public boolean insert(Category v) {
		String sql = "INSERT INTO category(artistID,name) VALUES (?,?)";
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
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Category v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category selectID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
