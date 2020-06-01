package curso.servlets06.redireccion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Redireccion
 */
@WebServlet("/redireccion")
public class Redireccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Redireccion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet");
		request.setAttribute("servletMsg", "este es el mensaje nuevo");
		// MEDIANTE EL 'getRequestDispatcher' SI PUEDO ENVIAR LOS ATRIBUTOS SIN NECESIDAD DE ESTAR EN UNA
		// SESION.
		//request.getRequestDispatcher("/jsp/06_redireccion/redireccionado.jsp").forward(request, response);
		// DE ESTA FORMA NO PUEDO RECOGER LOS ATRIBUTOS, DADO QUE NO ESTOY EN UNA SESION, Y ADEMAS EL
		// sendRedirect, NO ME PERMITE ENVIAR LOS ARTRIBUTOS.
		response.sendRedirect(request.getContextPath() + "/jsp/06_redireccion/redireccionado.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
