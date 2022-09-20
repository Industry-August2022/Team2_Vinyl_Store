package team2.vinyl_store.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String dBURL = "jdbc:mysql://localhost:3306/vinyl_store";
	private Connection connect;

	public DBConnection() {
		try {
			this.connect = DriverManager.getConnection(dBURL, "app", "app");
			if(this.connect != null) {
				System.out.println("Successful Connection!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		DBConnection connect = new DBConnection();
	}
	
}
