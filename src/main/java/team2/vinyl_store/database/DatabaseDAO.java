package team2.vinyl_store.database;

import java.util.List;

public interface DatabaseDAO<T> {
	
	static final String DBURL = "jdbc:mysql://localhost:3306/vinyl_store";
	static final String USER = "app";
	static final String PASS = "app";

	/***
	 * Insert new row of type T into the database.
	 * @param v
	 * @return
	 */
	public boolean insert(T v);

	/***
	 * Update row with ID specified in the supplied class of type T.
	 * @param v
	 * @return
	 */
	public boolean update(T v);

	/***
	 * Delete row with ID specified in the supplied class of type T.
	 * @param v
	 * @return
	 */
	public boolean delete(T v);

	/***
	 * Select row with ID specified in the supplied class of type T.
	 * @param v
	 * @return
	 */
	public T selectID(int id);

	/***
	 * Selects all values in the table.
	 * @param v
	 * @return
	 */
	public List<T> selectAll();

}
