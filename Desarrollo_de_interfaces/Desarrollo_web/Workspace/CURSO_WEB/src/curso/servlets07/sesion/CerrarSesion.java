package curso.servlets07.sesion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sesion
 */
@WebServlet("/cerrarsesion")
public class CerrarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CerrarSesion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mensaje = (String) request.getSession().getAttribute("nombre");
		System.out.println("cerrar sesi�n: " + mensaje);

		// invalidar atributo (deslogar)
		request.getSession().setAttribute("nombre", null);
		// request.getSession().invalidate();

		mensaje = (String) request.getSession().getAttribute("nombre");
		System.out.println("cerrar sesi�n: " + mensaje);

		response.sendRedirect(request.getContextPath() + "/jsp/07_sesion/sesion2.jsp");
	}

}
