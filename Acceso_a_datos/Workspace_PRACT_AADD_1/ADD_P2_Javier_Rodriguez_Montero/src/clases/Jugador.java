package clases;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import pdf_content.PDFHeaderFooter;

public class Jugador {

	private String nombre;
	private int puntuacion;
	private int num_preguntas_acertadas;
	static Scanner sc = new Scanner(System.in);

	public Jugador() {
		this.nombre = "";
		this.puntuacion = 0;
		this.num_preguntas_acertadas = 0;
	}

	public Jugador(String nombre, int puntuacion, int num_preguntas_acertadas) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
		this.num_preguntas_acertadas = num_preguntas_acertadas;
	}
	
	public static void mostrar_informe(String nombre, int puntuacion, int preguntas_acertadas) {
		/**
		 * Además, una vez acabe cada partida, se pedirá al usuario si quiere que se
		 * muestre un informe en PDF con el resultado de la misma: la puntuación
		 * obtenida, la corrección de las preguntas, etc.: partida.pdf
		 */
		Jugador j = new Jugador(nombre, puntuacion, preguntas_acertadas);
		PdfWriter writer = null;
		// Tamaño de pagina, margenes, etc.
		Document documento = new Document(PageSize.A4, 20, 20, 70, 50);
		try {
			File f = new File(Files.getRuta_files() + "partida.pdf");
			if (!f.exists())
				f.createNewFile();
			writer = PdfWriter.getInstance(documento, new FileOutputStream(f));
			writer.setPageEvent(new PDFHeaderFooter());
			documento.open();

			// PARRAFO
			Paragraph paragraph = new Paragraph();
			String parrafo_puntuacion = "Puntuacion total obtenida:";

			paragraph.setSpacingBefore(100);
			paragraph.add("\n\n");
			String font = "Sans";
			float tamanno = 11;
			int style = Font.BOLD;
			BaseColor color = BaseColor.BLACK;
			float spacBefore = 0;
			float spacAfter = 5;

			// paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.setFont(new Font(FontFactory.getFont(font, tamanno, style, color)));
			paragraph.add(parrafo_puntuacion);
			paragraph.setSpacingBefore(spacBefore);
			paragraph.setSpacingAfter(spacAfter);

			documento.add(paragraph);

			// TABLA
			PdfPTable tabla = new PdfPTable(3);

			// Contenido de la cabecera de la celda
			Phrase texto_celda1 = new Phrase("Nombre del Jugador");

			PdfPCell cont_celda1 = new PdfPCell(texto_celda1);
			cont_celda1.setBackgroundColor(BaseColor.CYAN);
			cont_celda1.setBorderWidth(1);
			cont_celda1.setBorderColor(BaseColor.BLUE);
			cont_celda1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cont_celda1.setVerticalAlignment(PdfPCell.ALIGN_TOP);
			cont_celda1.setPaddingBottom(3);

			Phrase texto_celda2 = new Phrase("Puntuacion total");

			PdfPCell cont_celda2 = new PdfPCell(texto_celda2);
			cont_celda2.setBackgroundColor(BaseColor.CYAN);
			cont_celda2.setBorderWidth(1);
			cont_celda2.setBorderColor(BaseColor.BLUE);
			cont_celda2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cont_celda2.setVerticalAlignment(PdfPCell.ALIGN_TOP);
			cont_celda2.setPaddingBottom(3);

			Phrase texto_celda3 = new Phrase("Preguntas acertadas");

			PdfPCell cont_celda3 = new PdfPCell(texto_celda3);
			cont_celda3.setBackgroundColor(BaseColor.CYAN);
			cont_celda3.setBorderWidth(1);
			cont_celda3.setBorderColor(BaseColor.BLUE);
			cont_celda3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cont_celda3.setVerticalAlignment(PdfPCell.ALIGN_TOP);
			cont_celda3.setPaddingBottom(3);

			tabla.addCell(cont_celda1);
			tabla.addCell(cont_celda2);
			tabla.addCell(cont_celda3);
			tabla.addCell(j.getNombre());
			tabla.addCell(String.valueOf(j.getPuntuacion()));
			tabla.addCell(String.valueOf(j.getNum_pregunta_fallada()));

			documento.add(tabla);

			documento.close();
			writer.close();

			File path = new File(Files.getRuta_files() + "partida.pdf");
			Desktop.getDesktop().open(path);

		} catch (FileNotFoundException e) {
			System.err.println("\nERROR EN LA ESCRITURA DEL ARCHIVO.");
			e.printStackTrace();
		} catch (DocumentException e) {
			System.err.println("\nERROR EN EL INFORME PDF.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("\nERROR AL ABRIR EL INFORME.");
			e.printStackTrace();
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getNum_pregunta_fallada() {
		return num_preguntas_acertadas;
	}

	public void setNum_pregunta_fallada(int num_preguntas_acertadas) {
		this.num_preguntas_acertadas = num_preguntas_acertadas;
	}

	public String toString() {
		return ("\nNombre: " + this.nombre + "\nPuntuacion total: " + this.puntuacion
				+ "\nNumero de preguntas acertadas: " + this.num_preguntas_acertadas + "\n");
	}
}
