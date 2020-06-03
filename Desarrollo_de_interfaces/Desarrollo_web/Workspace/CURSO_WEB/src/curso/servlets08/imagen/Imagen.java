package curso.servlets08.imagen;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class Imagen
 */
@WebServlet("/imagen")
public class Imagen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Imagen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String applicationPath = request.getServletContext().getRealPath("");
		String uploadFilePath = applicationPath + File.separator + "img" + File.separator;
		
		FileInputStream myStream = null;
		try { 
			myStream = new FileInputStream(uploadFilePath + "pepapig.jpg");
		} catch (Exception errorDeFichero) { 
			System.out.println("Ha habido problemas: " + errorDeFichero.getMessage()); 
		} 
		byte[] byteArray = IOUtils.toByteArray(myStream);
		
		String bphoto = Base64.getEncoder().encodeToString(byteArray);
		
		request.setAttribute("foto", bphoto);
		
		getServletConfig().getServletContext().getRequestDispatcher("/jsp/08_imagen/imagen.jsp").forward(request, response);
	}

}
