package curso.servlets02.parametros;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MiServlet
 */
@WebServlet("/parametro")
public class Parametro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Parametro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String NOMBRE = "pepe";
		final String CLAVE = "12345";
		
		String pass = request.getParameter("pass");
		String user = request.getParameter("user");
		
		System.out.println(pass);
		System.out.println(user);
		
		if(user.equals(NOMBRE) && pass.equals(CLAVE)) {
			System.out.println("Acceso permitido");
		}
		else {
			System.out.println("No tienes acceso");
		}
		//TODO: logica de login
		
		//System.out.println("Hola " + param);
		//System.out.println(param1);
		//response.getWriter().append("Parametro: ").append(param);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
