package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	
	public static Connection connection;
	
	public DataBase() {
		connection = connection();
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		DataBase.connection = connection;
	}
	
	public static Connection connection() {
		String user = "root";
		String password = "Puertoseguro3418";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nombrebasededatos?serverTimezone=UTC", user, password);
			System.out.println("\n\tDATABASE CONNECTION SUCCEDED.");
			return con;
		} catch (ClassNotFoundException e) {
			System.err.println("\n\tMYSQL CLASS NOT FOUND");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("\n\tCONNECTION ERROR");
			e.printStackTrace();
		}
		return null;
	}
}
