package servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// PARA REDIRECCIONAR A OTRO .jsp:
		// response.sendRedirect(request.getContextPath() + "Ruta al jsp que quiero
		// ir.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		// PARA REDIRECCIONAR A OTRO .jsp:
		// response.sendRedirect(request.getContextPath() + "Ruta al jsp que quiero
		// ir.");

		String rutaJspIdex = File.separator + "index.jsp";
		String rutaJspLogin = File.separator + "inicio.jsp";
		String nombreUsuario = request.getParameter("nombre");
		String contrasenaUsuario = request.getParameter("contrasena");

		if (!nombreUsuario.equals("Javier") || !contrasenaUsuario.equals("1234"))
			request.getRequestDispatcher(rutaJspIdex).forward(request, response);
		else {
			request.getSession().setAttribute("nombre", nombreUsuario);
			// request.getSession().setAttribute("contrasena", contrasenaUsuario);
			response.sendRedirect(request.getContextPath() + rutaJspLogin);
		}
		
	}

}
