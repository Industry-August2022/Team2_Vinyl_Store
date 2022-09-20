package team2.vinyl_store.database;

public interface DatabaseDAO<T> {

	public void insert(T v);

	public void update(T v);

	public void delete(T v);

}
