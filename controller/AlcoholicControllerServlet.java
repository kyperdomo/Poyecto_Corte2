/**
 * package in charge of the connection between the other packages
 */
package co.edu.unbosque.controller;

/**
 * classes or elements implemented for the correct use of the application, imported from the application itself or from Java's own classes
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import co.edu.unbosque.model.AlcoholicDTO;
import co.edu.unbosque.model.persistence.AlcoholicDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * This class is responsible for controlling the people's servlet, where we will
 * manage its logic and specific functions.
 */
public class AlcoholicControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -4331680861219300600L;
	private AlcoholicDAO aDao;
	private String password;

	/**
	 * Constructor that initializes the attributes of the class according to the
	 * developer's need
	 */
	public AlcoholicControllerServlet() {
		aDao = new AlcoholicDAO();
		password = "";
	}

	/**
	 * From the HTML POST request the servlet's doPost() method is called. The
	 * servlet performs its processes and returns something on the output stream.
	 * The response that comes from the servlet is initially received by the http
	 * Web service, which will also carry out its processes
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		password = req.getParameter("password");
		boolean status = aDao.validate(username, password);
		System.out.println(password);
		if (status) {
			RequestDispatcher rd = req.getRequestDispatcher("datumvis.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("login-error.jsp");
			rd.forward(req, resp);
		}
	}

	/**
	 * This method receives the parameters given by the client through the
	 * HttpServletRequest class and encapsulates the response to be given to the
	 * client through the HttpServletResponse class.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");

		if (action.equals("save")) {
			String name = req.getParameter("name");
			String[] aux = req.getParameter("fechaNacimiento").split("/");
			Date date = new Date(Integer.parseInt(aux[0]), Integer.parseInt(aux[0]), Integer.parseInt(aux[0]));
			int ide = Integer.parseInt(req.getParameter("DocIdentidad"));
			String city = req.getParameter("CiudadNac");
			int ses = Integer.parseInt(req.getParameter("SesionPar"));
			String nick = req.getParameter("Apodo");
			System.out.println(name + " " + date.toString() + "" + ide + "" + city);
			aDao.create(new AlcoholicDTO(name, ide, date, city, ses, nick));
			RequestDispatcher rd = req.getRequestDispatcher("login-exit.jsp");
			rd.forward(req, resp);
		} else if (action.equals("upload information")) {
			AlcoholicDTO temp = (AlcoholicDTO) aDao.readOnly(password);
			req.setAttribute("name", temp.getName());
			System.out.println(temp.getName());
			req.setAttribute("fechaNacimiento", temp.getBirthdate());
			System.out.println(temp.getBirthdate());
			req.setAttribute("DocIdentidad", temp.getIde());
			System.out.println(temp.getIde());
			req.setAttribute("CiudadNac", temp.getCityOfBirth());
			req.setAttribute("SesionPar", temp.getSessions());
			req.setAttribute("Apodo", temp.getNickname());
			req.getRequestDispatcher("datumvis.jsp").forward(req, resp);
		}
	}

}