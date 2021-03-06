package xls_content;

import java.io.File;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class EscribirExcel {
	
	public static void main(String[] args) {
		File fichero = new File("./ficheros/nueva.xls");
		
        try {
        	WritableWorkbook w = Workbook.createWorkbook(fichero);
        	
        	/*
        	Workbook wb = Workbook.getWorkbook(fichero);
        	WritableWorkbook w = Workbook.createWorkbook(fichero, wb);
        	*/
        	
        	//Nombre de la hoja
        	WritableSheet sheet = w.createSheet("Datos", 0);
        	
        	//columna fila contenido
        	jxl.write.Number number = new jxl.write.Number(0, 0, 1);
        	sheet.addCell(number);
        	
        	jxl.write.Label cadena = new jxl.write.Label(1, 0, "valor");
            sheet.addCell(cadena);

            w.write();
            w.close();
        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
  
}
