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
@WebServlet("/sesion")
public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dentro");
		String nombre = request.getParameter("nombre");
		
		request.getSession().setAttribute("nombre", nombre);
		
		//invalidar atributo (deslogar)
		//request.getSession().setAttribute("nombre", null);
		
		response.sendRedirect(request.getContextPath() + "/jsp/07_sesion/sesion2.jsp");
		//request.getRequestDispatcher("/sesion2.jsp").forward(request, response);
	}

}
