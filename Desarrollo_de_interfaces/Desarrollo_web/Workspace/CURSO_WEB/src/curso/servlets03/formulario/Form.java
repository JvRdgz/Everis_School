package curso.servlets03.formulario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Form
 */
@WebServlet("/form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request, response);
		operacion(request);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
//		String valor_nombre = request.getParameter("nombre");
//		String valor_oculto = request.getParameter("oculto");
//		
//		System.out.println(valor_nombre);
//		System.out.println(valor_oculto);
		operacion(request);
	}
	
	public void operacion(HttpServletRequest request) {
		String valor_nombre = request.getParameter("nombre");
		String valor_contrasena = request.getParameter("pass");
		
		// boolean comprobarUsuario(valor_nombre, valor_contrasena);
		System.out.println(valor_nombre);
		System.out.println(valor_contrasena);
		
		//redireccionamiento
	}

}
