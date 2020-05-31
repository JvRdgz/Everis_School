/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

import operaciones.EnviarFichero;
import operaciones.EstructuraFicheros;
import operaciones.ObtieneFichero;
import operaciones.PideFichero;

public class HiloServidor implements Runnable {

	private final Socket hiloServidor;
	private final ObjectOutputStream salida;
	private final ObjectInputStream entrada;
	private final EstructuraFicheros estructura;

	public HiloServidor(Socket hiloServidor, EstructuraFicheros estructura) throws IOException {
		this.hiloServidor = hiloServidor;
		this.estructura = estructura;
		this.salida = new ObjectOutputStream(hiloServidor.getOutputStream());
		this.entrada = new ObjectInputStream(hiloServidor.getInputStream());

	}

	public void enviarFichero(PideFichero fich) {
		try {

			// Creamos el contenido del fichero con un inputStream para pasarlo a nuestro
			// Objeto ObtieneFichero
			File f = new File(fich.getNombreFichero());
			FileInputStream fis;
			fis = new FileInputStream(f);
			long bytes = f.length();
			byte[] buffer = new byte[(int) bytes];
			int i;
			int j = 0;

			while ((i = fis.read()) != -1) {
				buffer[j] = (byte) i;
				j++;
			}

			fis.close();

			// Una vez compuesto el buffer, creamos nuestro objeto obtiene fichero y lo
			// enviamos
			Object obj = new ObtieneFichero(buffer);
			this.salida.writeObject(obj);

		} catch (FileNotFoundException ex) {
			Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void run() {
		try {
			// Mandamos la estructura previamente seleccionada al cliente
			salida.writeObject(estructura);
			// Mientras el cliente mantenga la conexion
			while (true) {
				// Recogemos la solicitud del cliente, la filtramos segun el tipo de objeto que
				// nos envía
				Object peticion = entrada.readObject();
				// Si el cliente pide Fichero
				if (peticion instanceof PideFichero) {
					// Recuperamos el objeto enviado
					PideFichero fichero = (PideFichero) peticion;
					// Enviamos el fichero al cliente
					enviarFichero(fichero);

				}
				// Si el cliente quiere subir un fichero
				if (peticion instanceof EnviarFichero) {
					// Recogemos el fichero que nos quiere enviar el cliente
					EnviarFichero fichero = (EnviarFichero) peticion;
					// Creamos un nuevo objeto file oara el directorio
					File dir = new File(fichero.getDirectorio());
					// creamos un objeto file para el fichero
					File f = new File(dir, fichero.getNombre());

					// Creamos un objeto para poder escribir el fichero enviado
					FileOutputStream fos = new FileOutputStream(f);
					fos.write(fichero.getContenidoFichero());
					fos.close();

					// Creamos de nuevo la estructura de ficheros para enviarla de nuevo al cliente
					EstructuraFicheros estructura2 = new EstructuraFicheros(fichero.getDirectorio());
					// Enviamos la estructura despues del cambio
					salida.writeObject(estructura2);
				}
			}
		} catch (IOException | ClassNotFoundException ex) {
			System.out.println("Error en el servidor al desconectar al cliente");
		}

	}

}
