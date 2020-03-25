package xls_content;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;

public class LeerExcel {
	
	public static final int XLS_COL_NOMBRE = 0;
	public static final int XLS_COL_DNI = 1;
	public static final String CADENA = "prueba";
	
	public static void main(String[] args) {
		File fichero = new File("./ficheros/nueva.xls");
		
        try {
        	Workbook w = Workbook.getWorkbook(fichero);
        	
        	//Se lee la primera hoja de la excel
        	Sheet sheet = w.getSheet(0);

        	leerExcel(sheet);
        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
    static public void leerExcel(Sheet sheet) throws Exception {
    		
    	for (int f=0; f<sheet.getRows(); f++) {
    		String contenido = " ";
    		for(int c=0;c<sheet.getColumns();c++) {
    			contenido += sheet.getCell(c,f).getContents() + "\t";// + sheet.getCell(c, f).getContents();
    		}
    		System.out.println(contenido);
    		
    	}
    }
  
}
