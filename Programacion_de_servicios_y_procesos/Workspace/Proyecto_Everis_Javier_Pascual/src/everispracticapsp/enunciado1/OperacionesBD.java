package everispracticapsp.enunciado1;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

/**
 * @author davidrc
 */
public class OperacionesBD {

    // CREAR BASE DE DATOS
    public static void crearBaseDeDatos() throws SQLException {
        // Crea la bbdd (comprueba que NO existe)
        // Para crearla es necesario establecer en la conexi�n una bbdd que ya existe previamente
        Main.st.executeUpdate("CREATE DATABASE IF NOT EXISTS curso");
    }

    // CREAR TABLA
    public static void crearTabla1() throws SQLException {
        Main.st.executeQuery("use examen");

        // Crea la tabla alumno (comprueba que NO existe)
        Main.st.executeUpdate("CREATE TABLE IF NOT EXISTS tabla1 ("
                + "id INT AUTO_INCREMENT, "
                + "PRIMARY KEY(id), "
                + "nombre VARCHAR(255), "
                + "apellidos VARCHAR(255), "
                + "telefono VARCHAR(255)"
                + ")");
        insertar1();
    }

    public static void crearTabla2() throws SQLException {
        Main.st.executeQuery("use examen");

        // Crea la tabla alumno (comprueba que NO existe)
        Main.st.executeUpdate("CREATE TABLE IF NOT EXISTS tabla2 ("
                + "id INT AUTO_INCREMENT, "
                + "PRIMARY KEY(id), "
                + "nombre VARCHAR(255), "
                + "apellidos VARCHAR(255), "
                + "telefono VARCHAR(255)"
                + ")");
        insertar2();
    }

    public static void crearTabla3() throws SQLException {
        Main.st.executeQuery("use examen");

        // Crea la tabla alumno (comprueba que NO existe)
        Main.st.executeUpdate("CREATE TABLE IF NOT EXISTS tabla3 ("
                + "id INT AUTO_INCREMENT, "
                + "PRIMARY KEY(id), "
                + "nombre VARCHAR(255), "
                + "apellidos VARCHAR(255), "
                + "telefono VARCHAR(255)"
                + ")");
        insertar3();
    }

    // INSERTAR REGISTRO (METODO 1)
    public static void insertar1() throws SQLException {
        String nombre = "Pepe";
        String apellidos = "Rubio Crespo";
        String telefono = "678453412";

        String query = "INSERT INTO tabla1 (nombre, apellidos, telefono) " + "VALUES ('" + nombre + "', '" + apellidos
                + "', '" + telefono + "');";

        int resultado = Main.st.executeUpdate(query);

        if (resultado == 0) {
            System.out.println("NO se ha podido insertar");
        }
        Main.conexion.commit();
    }

    public static void insertar2() throws SQLException {
        String nombre = "Pepe";
        String apellidos = "Rubio Crespo";
        String telefono = "678453412";

        String query = "INSERT INTO tabla2 (nombre, apellidos, telefono) " + "VALUES ('" + nombre + "', '" + apellidos
                + "', '" + telefono + "');";

        int resultado = Main.st.executeUpdate(query);

        if (resultado == 0) {
            System.out.println("NO se ha podido insertar");
        }
        Main.conexion.commit();
    }

    public static void insertar3() throws SQLException {
        String nombre = "Pepe";
        String apellidos = "Rubio Crespo";
        String telefono = "678453412";

        String query = "INSERT INTO tabla3 (nombre, apellidos, telefono) " + "VALUES ('" + nombre + "', '" + apellidos
                + "', '" + telefono + "');";

        int resultado = Main.st.executeUpdate(query);

        if (resultado == 0) {
            System.out.println("NO se ha podido insertar");
        }
        Main.conexion.commit();
    }

    // INSERTAR REGISTO (METODO 2)
    public static void insertar5() throws SQLException {
        String nombre = "Ursula";
        String apellidos = "Rubio Crespo";
        String telefono = "674123456";

        PreparedStatement ps = Main.conexion
                .prepareStatement("INSERT INTO alumno (nombre, apellidos, correo) " + "VALUES (?, ?, ?)");

        ps.setString(1, nombre);
        ps.setString(2, apellidos);
        ps.setString(3, telefono);
        int resultado = ps.executeUpdate();

        if (resultado == 0) {
            System.out.println("NO se ha podido insertar");
        }
        // conexion.commit();

        ps.close();
    }

    // CONSULTAR REGISTRO (METODO 1)
    public static void consultar() throws SQLException {
        System.out.println("Consultar registros:");
        String query = "SELECT * FROM alumno";
        System.out.println(query);
        ResultSet rs = Main.st.executeQuery(query);

        // Columnas de la tabla: nombre, apellidos y telefono
        while (rs.next()) {
            String nombre = rs.getString(2); // rs.getString("nombre");
            String apellidos = rs.getString(3); // rs.getString("apellidos");
            String telefono = rs.getString(4); // rs.getString("telefono");

            System.out.println(nombre + "\t" + apellidos + "\t" + telefono);
        }
        rs.close();
    }

    // CONSULTAR REGISTRO (METODO 2)
    //https://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
    public static void consultar2() throws SQLException {
        System.out.println("Consultar registros:");
        String query = "SELECT * FROM alumno WHERE nombre like ?";
        //System.out.println(query);
        PreparedStatement ps = Main.conexion.prepareStatement(query);
        ps.setString(1, "B%");

        ResultSet rs = ps.executeQuery();

        // Columnas de la tabla: nombre, apellidos y telefono
        while (rs.next()) {
            String nombre = rs.getString(2); // rs.getString("nombre");
            String apellidos = rs.getString(3); // rs.getString("apellidos");
            String telefono = rs.getString(4); // rs.getString("telefono");

            System.out.println(nombre + "\t" + apellidos + "\t" + telefono);
        }
        rs.close();
        ps.close();
    }

    // ACTUALIZAR REGISTRO
    public static void actualizar() throws SQLException {
        System.out.println("Actualizar registro:");
        String query = "UPDATE alumno SET nombre='Ernesto' WHERE id=1";
        System.out.println(query);
        int res = Main.st.executeUpdate(query);
        if (res == 0) {
            System.out.println("NO se ha podido actualizar");
        }
        // conexion.commit();
    }

    // BORRAR REGISTRO
    public static void borrar() throws SQLException {
        System.out.println("Borrar registro:");
        String query = "DELETE FROM alumno WHERE id=1";
        System.out.println(query);
        int res = Main.st.executeUpdate(query);
        if (res == 0) {
            System.out.println("NO se ha podido borrar");
        }
        // conexion.commit();
    }

    // BORRAR TABLA
    public static void borrarTabla() throws SQLException {
        // Borra la tabla alumno (comprueba que existe)
        Main.st.executeUpdate("DROP TABLE IF EXISTS alumno");
    }

    // BORRAR BASE DE DATOS
    public static void borrarBaseDeDatos() throws SQLException {
        // Borra la bbdd (comprueba que NO existe)
        Main.st.executeUpdate("DROP DATABASE curso");
    }

    public static int contarClientes(Connection conexion) throws SQLException {
        int contador = 0;

        String query = "SELECT * FROM tabla1";
        PreparedStatement ps = conexion.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            contador++;
        }
        
        rs.close();
        ps.close();
        //Conexion.desconectar();

        return contador;
    }

    public static int contarClientes() throws SQLException {
        int contador = 0;

        String query = "SELECT * FROM tabla1";
        //System.out.println(query);
        PreparedStatement ps = Main.conexion.prepareStatement(query);
        //ps.setString(1, "B%");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            contador++;
        }
        rs.close();
        ps.close();

        return contador;
    }
}
