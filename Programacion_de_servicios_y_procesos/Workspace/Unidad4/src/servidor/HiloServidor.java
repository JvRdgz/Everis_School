package servidor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import pedir_obtener_enviar.EnviaFichero;
import pedir_obtener_enviar.ObtieneFichero;
import pedir_obtener_enviar.PideFichero;

public class HiloServidor implements Runnable{

	private Socket hiloServidor;
	private ObjectOutputStream salidaCliente;
	private ObjectInputStream entradaCliente;
	private EstructuraFicheros NF;
	
	public HiloServidor(Socket hiloServidor, EstructuraFicheros NF) throws IOException {
		this.hiloServidor = hiloServidor;
		this.NF = NF;
		this.salidaCliente = new ObjectOutputStream(hiloServidor.getOutputStream());
		this.entradaCliente = new ObjectInputStream(hiloServidor.getInputStream());
	}
	
	private void enviarFichero(PideFichero fich) {
		try {
			File f = new File(fich.getNombreFichero());
			FileInputStream fis = null;
			fis = new FileInputStream(f);
			long bytes = f.length();
			byte[] buffer = new byte[(int)bytes];
			int i = 0;
			int j = 0;
			while ((i = fis.read()) != -1) {
				buffer[j] = (byte) i;
				j++;
			}
			fis.close();
			Object ob = new ObtieneFichero(buffer);
			this.salidaCliente.writeObject(ob);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	@Override
	public void run() {
		try {
			// MANDAMOS AL CLIENTE EL OBJETO EstructuraFicheros
			salidaCliente.writeObject(NF);
			while (true) {
				// OBTENGO LA ENTRADA DEL CLIENTE
				Object peticion = entradaCliente.readObject();
				// SI EL CLIENTE QUIERE DESCARGAR UN FICHERO
				if (peticion instanceof PideFichero) {
					PideFichero fichero = (PideFichero) peticion;
					enviarFichero(fichero);
				}
				// SI EL CLIENTE QUIERE SUBIR UN FICHERO
				if (peticion instanceof EnviaFichero) {
					EnviaFichero fichero = (EnviaFichero) peticion;
					File dir = new File(fichero.getDirectorio());
					File f = new File(dir, fichero.getNombre());
					
					// SE CREA EL FICHERO EN EL DIRECTORIO
					// CON LOS BYTES TRANSFERIDOS
					FileOutputStream fos = new FileOutputStream(f);
					fos.write(fichero.getContenidoFichero());
					fos.close();
					
					// SE CREA LA NUEVA ESTRUCTURA DE FICHEROS
					EstructuraFicheros ef = new EstructuraFicheros(fichero.getDirectorio());
					salidaCliente.writeObject(ef);
				}
			}
		} catch (IOException e) {
			Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, e);
		} catch (ClassNotFoundException e) {
			Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
