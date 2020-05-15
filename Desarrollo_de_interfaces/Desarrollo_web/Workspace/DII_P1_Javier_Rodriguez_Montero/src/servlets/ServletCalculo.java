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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Double op1 = Double.parseDouble(request.getParameter("operando1"));
		String op = request.getParameter("operacion");
		Double op2 = Double.parseDouble(request.getParameter("operando2"));
		Double result = Calculo.result(op, op1, op2);
		String rutaJsp = File.separator + "index.jsp";

		/*
		 * System.out.println(op1); System.out.println(op2); System.out.println(op);
		 * System.out.println(result);
		 */

		/*
		 * request.setAttribute("operando1", op1); request.setAttribute("operacion",
		 * op); request.setAttribute("operando2", op2);
		 */
		request.setAttribute("resultado", result.toString());
		request.getRequestDispatcher(rutaJsp).forward(request, response);

		// doGet(request, response);
	}

}
