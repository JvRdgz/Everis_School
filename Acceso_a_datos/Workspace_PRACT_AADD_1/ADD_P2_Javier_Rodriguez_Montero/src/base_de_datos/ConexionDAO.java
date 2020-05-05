package base_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import clases.Files;
import properties.Config;

public class ConexionDAO {

	public static Connection conexion;
//	static String bd = "company";
//	static String user = "root";
//	static String password = "password";
//	static String host = "localhost"; // LOCALHOST
//	static String host = "127.0.0.1";
//	static int port = 3306;
//	static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, bd); // INCLUYENDO EL PUERTO	
	static String bd = Config.getParametro(Files.getBbddd_properties(), "bd.nombre");
	static String user = Config.getParametro(Files.getBbddd_properties(), "bd.user");
	static String password = Config.getParametro(Files.getBbddd_properties(), "bd.password");
	static String host = Config.getParametro(Files.getBbddd_properties(), "bd.host");
	static String url = String.format("jdbc:mysql://%s/%s?useSSL=false", host, bd); // NO ES NECESARIO INCLUIR EL PUERTO
	// static String url = "jdbc:mysql://localhost:3306/" + bd + "?user=" + user +
	// "&password=" + password + "&useUnicode=true&characterEncoding=UTF-8";

	public ConexionDAO() {
		conexion = getConexion();
	}
	
	// DEVUELVE true SI SE HA CREADO CORRECTAMENTE
	public static boolean crearConexion() {
		try {
			// CARGO EL DRIVER
			Class.forName("com.mysql.jdbc.Driver");
			// GUARDA LA CONEXION EN EL OBJETO
			conexion = DriverManager.getConnection(url, user, password);
			// conexion = DriverManager.getConnection((url + host + port + "/" + bd), user,
			// password);
			// ESTO ES RECOMENDABLE POR SI SE DA EL CASO DE QUE SE DE UN ERROR DE CUALQUIER
			// TIPO
			// Y LA BASE DE DATOS NO LO DETECTE Y FINALMENTE SE DE ACABO. PARA EVITAR ESTO,
			// PONEMOS EL setAutoCommit A false.
			// DESPUES DE CADA OPERACION, DEBEMOS DE FORZAR UN COMMIT PARA ESTABLECER LOS
			// CAMBIOS,
			// SIEMPRE Y CUANDO LO DEJEMOS ASI, SINO, HACIENDO UN setAutoCommit(true) LO
			// HACE
			// AUTOMATICAMENTE PERO NO ES RECOMENDABLE.
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
	
	

	/*
	 * public static void main(String[] args) { Connection c =
	 * ConexionDAO.getConexion(); System.out.println(c); System.out.println(bd);
	 * System.out.println(user); System.out.println(password);
	 * System.out.println(host); System.out.println(url); }
	 */

}
