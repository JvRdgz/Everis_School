package operaciones_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.Cliente;

public class ClienteDAO {

	private static Connection conexion;

	public static Connection getConexion() {
		return conexion;
	}

	public static void setConexion(Connection conexion) {
		ClienteDAO.conexion = conexion;
	}

	public static void registrarCliente(Cliente cliente) {
		int res_stmt = 0;
		PreparedStatement stmt;
		String query = "INSERT INTO cliente (codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, linea_direccion1, linea_direccion2, ciudad, region, pais, codigo_postal, codigo_empleado_rep_ventas, limite_credito) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		System.out.println(query);
		try {
			stmt = conexion.prepareStatement(query);
			stmt.setInt(1, cliente.getCodigo_cliente());
			stmt.setString(2, cliente.getNombre_cliente());
			stmt.setString(3, cliente.getNombre_contacto());
			stmt.setString(4, cliente.getApellido_contacto());
			stmt.setString(5, cliente.getTelefono());
			stmt.setString(6, cliente.getFax());
			stmt.setString(7, cliente.getLinea_direccion1());
			stmt.setString(8, cliente.getLinea_direccion2());
			stmt.setString(9, cliente.getCiudad());
			stmt.setString(10, cliente.getRegion());
			stmt.setString(11, cliente.getPais());
			stmt.setString(12, cliente.getCodigo_postal());
			stmt.setInt(13, cliente.getCodigo_empleado_rep_ventas());
			stmt.setDouble(14, cliente.getLimite_credito());
			res_stmt = stmt.executeUpdate();
			if (res_stmt == 1)
				System.out.println("Cliente insertado correctamente.");
			else
				System.err.println("\n\tERROR AL INSERTAR EN LA BASE DE DATOS.");
			conexion.commit();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("\n\tERROR SQL CON LA BASE DE DATOS.");
			e.printStackTrace();
		}
	}
}
