package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	static String bd = "company";
	static String login = "root";
	static String password = "password";
	static String host = "127.0.0.1"; //localhost
	
	static String url = "jdbc:mysql://";
	static Connection conexion; //atributo para guardar el objeto Connection
	
    public static Connection getConexion() {
	    if (conexion == null) {
	    	crearConexion();
	    }
	    return conexion;
    }
    
    // devuelve true si se ha creado correctamente
    public static boolean crearConexion() {
	    try {
	        //cargo el driver
	        Class.forName("com.mysql.jdbc.Driver");
	        conexion = DriverManager.getConnection(url + host + "/"+ bd + "?useSSL=false", login, password);
	        conexion.setAutoCommit(false);
	        
	    } catch (SQLException e) {
	    	System.out.println(e);
	    	return false;
	    }
	    catch (Exception e) {
	    	System.out.println(e);
	    	return false;
	    }
	    return true;
    }

    public static void desconectar(){
    	try {
    		conexion.close();
            conexion = null;
            System.out.println("La conexion a la base de datos " + bd + " ha terminado");
    	
    	} catch (SQLException e) {
    		System.out.println("Error al cerrar la conexion");
        }
    }
   
    public static void main(String[] args) {
    	Connection c = Conexion.getConexion();
    	System.out.println(c);
    	// c = Conexion.getConexion();
    	// System.out.println(c);
    }

}
