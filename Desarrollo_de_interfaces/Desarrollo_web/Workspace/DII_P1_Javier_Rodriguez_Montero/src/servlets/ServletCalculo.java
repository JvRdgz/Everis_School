package servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Calculo;

/**
 * Servlet implementation class ServletCalculo
 */
@WebServlet("/calculadora")
public class ServletCalculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCalculo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Double operando1 = Double.parseDouble(request.getParameter("operando1"));
		String operacion = request.getParameter("operacion");
		Double operando2 = Double.parseDouble(request.getParameter("operando2"));
		Double resultado = Calculo.result(operacion, operando1, operando2);
		String rutaJsp = File.separator + "jsp" + File.separator + "jspCalculadora" + File.separator + "index.jsp";
		
		System.out.println(operando1);
		System.out.println(operando2);
		System.out.println(operacion);
		System.out.println(resultado);
		
		request.setAttribute("operando1", request.getParameter("operando1"));
		request.setAttribute("operacion", request.getParameter("operando"));
		request.setAttribute("operando2", request.getParameter("operando2"));
		request.setAttribute("resultado", resultado.toString());
		request.getRequestDispatcher(rutaJsp).forward(request, response);

		// doGet(request, response);
	}

}
