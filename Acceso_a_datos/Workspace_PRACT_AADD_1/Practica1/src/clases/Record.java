package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Record {

	public static void visualizar_records() {
		// Compruebo que existe el fichero records.txt
		File f_records = new File(Menu.getRuta() + "records.txt");
		int[] puntuacion_records;
		if (!f_records.exists()) {
			try {
				f_records.createNewFile();
			} catch (IOException e) {
				System.err.println("\nERROR AL CREAR EL ARCHIVO.");
				e.printStackTrace();
			}
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(f_records));
			String s = br.readLine();
			int tam_record_array = 0;
			// Calculamos el tama�o que va a tener el array puntuacion_recods.
			while (s != null) {
				tam_record_array++;
				s = br.readLine();
			}
			br.close();
			s = null;
			// Reiniciamos el Buffer
			br = new BufferedReader(new FileReader(f_records));
			s = br.readLine();
			puntuacion_records = new int[tam_record_array];
			int pos = 0;
			// Guardamos las puntuaciones del fichero en el array puntuacion_records.
			while (s != null) {
				String[] datos_records = s.split(":");
				puntuacion_records[pos] = Integer.parseInt(datos_records[1]);
				pos++;
				s = br.readLine();
			}
			// Ordenamos el array puntuacion_records con .sort(), aunque tambien tengo el
			// metodo
			// de ordenacion por insercion.
			Arrays.sort(puntuacion_records);
			// insercion(puntuacion_records);
			int j = 0;
			// Lo mostramos en orden decreciente, dado que sort te lo ordena de menor a
			// mayor.
			for (int i = puntuacion_records.length - 1; i >= 0; i--)
				System.out.println((++j) + ".- " + puntuacion_records[i]);
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("\nERROR AL ABRIR EL ARCHIVO.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("\nERROR EN LA LECTURA DE DATOS.");
			e.printStackTrace();
		}
	}
}
