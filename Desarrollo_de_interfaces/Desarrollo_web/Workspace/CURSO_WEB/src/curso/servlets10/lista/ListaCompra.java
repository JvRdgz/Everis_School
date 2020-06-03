package curso.servlets10.lista;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaCompra
 */
@WebServlet("/ListaCompra")
public class ListaCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListaCompra() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dentro");
		ArrayList<String> listaElementos = (ArrayList<String>) request.getSession().getAttribute("misElementos");

		if (listaElementos == null) {
			listaElementos = new ArrayList<String>();
			request.getSession().setAttribute("misElementos", listaElementos);
		}

		String[] elementos = request.getParameterValues("articulos");

		if (elementos != null) {
			for (String el : elementos) {
				listaElementos.add(el);
			}
		}

		response.sendRedirect(request.getContextPath() + "/jsp/10_lista/listaCompra2.jsp");
	}

}
