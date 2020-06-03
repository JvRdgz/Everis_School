package curso.servlets01.inicial;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundo
 */
@WebServlet("/hola")
public class MiSaludo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String nombre;
	
	public void init() throws ServletException {
		// Do required initialization
		nombre = "Pepe";
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MiSaludo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<title>Mi primer servlet</title>");
		out.println("<body>");
		out.println("<h1>Hola " + nombre + "</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		//1
		String cadena = getServletConfig().getServletContext().getContextPath();
		System.out.println(cadena);
		//2
		cadena = request.getContextPath();
		System.out.println(cadena);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
