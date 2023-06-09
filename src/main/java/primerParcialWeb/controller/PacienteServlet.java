package primerParcialWeb.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import primerParcialWeb.dao.PacienteDao;
import primerParcialWeb.modelo.Paciente;

/**
 * Servlet implementation class PacienteServlet
 */
@WebServlet("/PacienteServlet")
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PacienteDao pacienteDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.pacienteDao = new PacienteDao();
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

		try {
			switch (action) {

			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertarPaciente(request, response);
				break;
			case "/delete":
				eliminarPaciente(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				actualizarPaciente(request, response);

				break;
			default:
				listPaciente(request, response);
				break;

			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("paciente.jsp");
		dispatcher.forward(request, response);
	}

	private void insertarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		int documento = Integer.parseInt(request.getParameter("documento"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String fechaNacimiento = request.getParameter("fechaNacimiento");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		int peso = Integer.parseInt(request.getParameter("peso"));
		int estatura = Integer.parseInt(request.getParameter("estatura"));
		
		

		Paciente paciente = new Paciente(documento, nombre, apellido, email, 
    			genero, fechaNacimiento, telefono, direccion, peso, estatura);

		pacienteDao.insert(paciente);

		response.sendRedirect("list");

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));

		Paciente pacienteActual = pacienteDao.select(id);

		request.setAttribute("paciente", pacienteActual);

		RequestDispatcher dispatcher = request.getRequestDispatcher("paciente.jsp");
		dispatcher.forward(request, response);

	}

	private void actualizarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));

		int documento = Integer.parseInt(request.getParameter("documento"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String fechaNacimiento = request.getParameter("fechaNacimiento");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		int peso = Integer.parseInt(request.getParameter("peso"));
		int estatura = Integer.parseInt(request.getParameter("estatura"));
		
		

		Paciente paciente = new Paciente(documento, nombre, apellido, email, 
    			genero, fechaNacimiento, telefono, direccion, peso, estatura);

		pacienteDao.update(paciente);

		response.sendRedirect("list");

	}

	private void eliminarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));

		pacienteDao.delete(id);

		response.sendRedirect("list");
	}

	private void listPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		List<Paciente> listPacientes = pacienteDao.selectAll();
		request.setAttribute("listPacientes", listPacientes);

		RequestDispatcher dispatcher = request.getRequestDispatcher("pacientelist.jsp");
		dispatcher.forward(request, response);

	}


}
