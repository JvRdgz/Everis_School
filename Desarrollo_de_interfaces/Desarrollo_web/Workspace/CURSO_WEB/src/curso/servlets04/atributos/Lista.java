package curso.servlets04.atributos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lista
 */
@WebServlet("/listado")
public class Lista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lista() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init() throws ServletException {
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
		ArrayList<Alumno> listado = cargarDatos();
		
		request.setAttribute("alumnos", listado);
		request.setAttribute("nombre", "pepe");
		
		getServletContext().getRequestDispatcher("/jsp/04_atributos/lista2.jsp").forward(request, response);
		//request.getRequestDispatcher("/jsp/04_atributos/lista.jsp").forward(request, response);
	}
	
	private ArrayList<Alumno> cargarDatos() {
	
		ArrayList<Alumno> listado = new ArrayList<Alumno>();
		Alumno alumno = new Alumno("Pedro", "Rodriguez", "678595959");
		listado.add(alumno);
		alumno = new Alumno("Paco", "Martinez", "698213456");
		listado.add(alumno);
		alumno = new Alumno("Ernesto", "Ramirez", "645672345");
		listado.add(alumno);
				
		return listado;
	}

}
