package operaciones_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDAO {

	public static Connection conexion;
	static String bd = "jardineria";
	static String user = "jarodrig";
	static String password = "password";
	static String host = "127.0.0.1";
	static String url = String.format("jdbc:mysql://%s/%s?useSSL=false", host, bd); // NO ES NECESARIO INCLUIR EL PUERTO

	public ConexionDAO() {
		conexion = getConexion();
	}

	// DEVUELVE true SI SE HA CREADO CORRECTAMENTE
	public static boolean crearConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, user, password);
			conexion.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
			return false;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
		System.out.println("\n\tCONEXION CON BASE DE DATOS REALIZADA.");
		return true;
	}

	// PATRON SINGLETON
	public static Connection getConexion() {
		if (conexion == null) {
			crearConexion();
		}
		return conexion;
	}

	public static void desconectar() {
		try {
			conexion.close();
			conexion = null;
			System.out.println("\n\tConexion con la base de datos " + bd + " terminada.");
		} catch (SQLException e) {
			System.err.println("\n\tError al cerrar la conexion con la base de datos + " + bd + ".");
			System.err.print(e);
		}
	}

	public static String getBd() {
		return bd;
	}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return password;
	}

	public static String getHost() {
		return host;
	}

	public static String getUrl() {
		return url;
	}
}
