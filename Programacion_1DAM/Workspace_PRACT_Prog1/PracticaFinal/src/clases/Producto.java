package clases;

public class Producto {

	private String codigoProducto;
	private String nombre;
	private String gama;
	private String dimensiones;
	private String proveedor;
	private String descripcion;
	private int cantidadEnStock;
	private int precioVenta;
	private int precioProveedor;

	public Producto(String codigo_producto, String nombre, String gama, String dimensiones, String proveedor,
			String descripcion, int cantidadEnStock, int precioVenta, int precioProveedor) {
		this.codigoProducto = codigo_producto;
		this.nombre = nombre;
		this.gama = gama;
		this.dimensiones = dimensiones;
		this.proveedor = proveedor;
		this.descripcion = descripcion;
		this.cantidadEnStock = cantidadEnStock;
		this.precioVenta = precioVenta;
		this.precioProveedor = precioProveedor;
	}

	public String getCodigo_producto() {
		return codigoProducto;
	}

	public void setCodigo_producto(String codigo_producto) {
		this.codigoProducto = codigo_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGama() {
		return gama;
	}

	public void setGama(String gama) {
		this.gama = gama;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidadEnStock() {
		return cantidadEnStock;
	}

	public void setCantidadEnStock(int cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}

	public int getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getPrecioProveedor() {
		return precioProveedor;
	}

	public void setPrecioProveedor(int precioProveedor) {
		this.precioProveedor = precioProveedor;
	}

	@Override
	public String toString() {
		return "Producto [codigo_producto=" + codigoProducto + ", nombre=" + nombre + ", gama=" + gama
				+ ", dimensiones=" + dimensiones + ", proveedor=" + proveedor + ", descripcion=" + descripcion
				+ ", cantidadEnStock=" + cantidadEnStock + ", precioVenta=" + precioVenta + ", precioProveedor="
				+ precioProveedor + "]";
	}

	public String toStringJTable() {
		return "codigo_producto=" + codigoProducto + ", nombre=" + nombre + ", gama=" + gama + ", dimensiones="
				+ dimensiones + ", proveedor=" + proveedor + ", descripcion=" + descripcion + ", cantidadEnStock="
				+ cantidadEnStock + ", precioVenta=" + precioVenta + ", precioProveedor=" + precioProveedor;
	}

}
