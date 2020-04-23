package curso.servlets05.calculadora;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calcular
 */
@WebServlet("/calcular")
public class Calcular extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calcular() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer op1 = Integer.parseInt(request.getParameter("operando1"));
		Integer operando2 = Integer.parseInt(request.getParameter("operando2"));
		
		String operacion = request.getParameter("operacion"); //obtener un parámetro de la url que se llame operacion
		System.out.println(operacion);
		
		Integer resultado = op1 + operando2;
		
		request.setAttribute("result", resultado.toString());
		
		request.setAttribute("operando1", request.getParameter("operando1"));
		
		request.getRequestDispatcher("/jsp/05_calculadora/index.jsp").forward(request, response);
		//request.getSession().setAttribute("result", resultado.toString());
	}

}
