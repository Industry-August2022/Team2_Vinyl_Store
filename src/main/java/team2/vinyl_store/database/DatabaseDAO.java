package team2.vinyl_store.database;

import java.util.List;

public interface DatabaseDAO<T> {
	
	static final String DBURL = "jdbc:mysql://localhost:3306/vinyl_store";
	static final String USER = "app";
	static final String PASS = "app";

	public boolean insert(T v);

	public boolean update(T v);

	public boolean delete(T v);
	
	public T selectID(int id);
	
	public List<T> selectAll();

}
