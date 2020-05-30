package operaciones_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Producto;

public class ProductoDAO {

	private static Connection conexion;

	public static Connection getConexion() {
		return conexion;
	}

	public static void setConexion(Connection conexion) {
		ProductoDAO.conexion = conexion;
	}

	public static ArrayList<Producto> consultarProductos() {
		ArrayList<Producto> arr_productos = new ArrayList<Producto>();
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM producto;");
			// EL ResultSet ES UN ARRAY DE VARIAS TABLAS.
			while (rs.next()) {
				String codigo_producto = rs.getString("codigo_producto");
				String nombre = rs.getString("nombre");
				String gama = rs.getString("gama");
				String dimensiones = rs.getString("dimensiones");
				String proveedor = rs.getString("proveedor");
				String descripcion = rs.getString("descripcion");
				int cantidad_en_stock = rs.getInt("cantidad_en_stock");
				int precio_venta = rs.getInt("precio_venta");
				int precio_proveedor = rs.getInt("precio_proveedor");
				Producto p = new Producto(codigo_producto, nombre, gama, dimensiones, proveedor, descripcion,
						cantidad_en_stock, precio_venta, precio_proveedor);
				// System.out.println(c);
				arr_productos.add(p);
			}
			conexion.commit();
			return arr_productos;
		} catch (SQLException e) {
			System.err.println("\n\tERROR AL LEER DATOS EN LA TABLA.");
			return null;
		}
	}
}
