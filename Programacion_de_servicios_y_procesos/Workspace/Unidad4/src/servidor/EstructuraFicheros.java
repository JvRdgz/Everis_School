package servidor;

import java.io.File;
import java.io.Serializable;

public class EstructuraFicheros implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre; // NOMBRE DEL DIRECTORIO
	private String path; // NOMBRE COMPLETO (RUTA)
	private boolean esDir; // INDICA SI ES O NO UN DIRECTORIO
	private int numFich; // NUMERO DE FICHEROS QUE TIENE EL DIRECTORIO
	private EstructuraFicheros[] lista; // ARRAY DE OBJETOS
	// QUE CONTIENE LOS FICHEROS Y SUBDIRECTORIOS DEL DIRECTORIO SELECCIONADO
	
	// CONSTRUCTOR QUE ES LLAMADO DESDE EL SERVIDOR
	// RECIBE COMO PARAMETRO EL DIRECTORIO SELECCIONADO
	public EstructuraFicheros(String dir) {
		File f = new File(dir);
		this.nombre = f.getName();
		this.path = f.getPath();
		this.esDir = f.isDirectory();
		this.lista = getListaFiles();
		if (f.isDirectory()) {
			File []ficheros = f.listFiles();
			if (ficheros != null)
				this.numFich = ficheros.length;
		}
	}
	
	// CONSTRUCTOR QUE ES LLAMADO DESDE EL METODO getListaFiles()
	public EstructuraFicheros(String nombre, String path, boolean esDir, int numFich) {
		this.nombre = nombre;
		this.path = path;
		this.esDir = esDir;
		this.numFich = numFich;
	}
	
	// GETTER
	public String getNombre() {
		String nombre_dir = this.nombre;
		if (this.esDir) {
			int pos = this.path.lastIndexOf(File.separator);
			nombre_dir = this.path.substring(pos + 1, this.path.length());
		}
		return nombre_dir;
	}

	public String getPath() {
		return path;
	}

	public boolean isEsDir() {
		return esDir;
	}

	public int getNumFich() {
		return numFich;
	}

	public EstructuraFicheros[] getLista() {
		return lista;
	}
	
	private EstructuraFicheros[] getListaFiles() {
		EstructuraFicheros[] lista = null;
		String sDirectorio = this.path;
		File f = new File(sDirectorio);
		File[] ficheros = f.listFiles();
		int longitud = ficheros.length;
		
		if (longitud > 0) {
			lista = new EstructuraFicheros[longitud];
			for (int i = 0; i < ficheros.length; i++) {
				EstructuraFicheros elemento;
				String nombre = ficheros[i].getName();
				String path = ficheros[i].getPath();
				boolean esDir = ficheros[i].isDirectory();
				int num = 0;
				if (esDir) {
					File[] fich = ficheros[i].listFiles();
					if (fich != null)
						num = fich.length;
				}
				elemento = new EstructuraFicheros(nombre, path, esDir, num);
				lista[i] = elemento;
			}
		}
		return (lista);
	}
	
	@Override
	public String toString() {
		String nombre = this.nombre;
		if (this.esDir)
			nombre = " (DIR) " + this.nombre;
		return nombre;
	}
	
}
