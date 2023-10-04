package co.edu.unbosque.controller;

import java.io.IOException;
import java.sql.Date;

import co.edu.unbosque.model.AlcoholicDTO;
import co.edu.unbosque.model.persistence.AlcoholicDAO;
import co.edu.unbosque.model.persistence.GeneralServicesDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GeneralControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1418737104877213599L;
	private GeneralServicesDAO gDao;
	private AlcoholicDAO aDao;

	public GeneralControllerServlet() {
		gDao = new GeneralServicesDAO();
		aDao = new AlcoholicDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean status = gDao.validate(username, password);
		status = true;
		if (status) {
			RequestDispatcher rd = req.getRequestDispatcher("crudgen.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("login-error.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");

		System.out.println(operation);
		switch (operation) {
		case "create": {
			RequestDispatcher rd = req.getRequestDispatcher("creategen.jsp");
			rd.forward(req, resp);
			break;
		}

		case "read": {
			RequestDispatcher rd = req.getRequestDispatcher("readgen.jsp");
			rd.forward(req, resp);
			break;
		}
		case "update": {
			RequestDispatcher rd = req.getRequestDispatcher("updategen.jsp");
			rd.forward(req, resp);
			break;
		}
		case "delete": {
			RequestDispatcher rd = req.getRequestDispatcher("deletegen.jsp");
			rd.forward(req, resp);
			break;
		}
		case "Savevis": {
			String name = req.getParameter("nombre");
			String[] aux = req.getParameter("fecha").split("/");
			Date date = new Date(Integer.parseInt(aux[0]), Integer.parseInt(aux[0]), Integer.parseInt(aux[0]));
			int ide = Integer.parseInt(req.getParameter("cedula"));
			String city = req.getParameter("ciudad");
			int sesi = Integer.parseInt(req.getParameter("cedula"));
			String nick = req.getParameter("apodo");
			AlcoholicDTO temp = new AlcoholicDTO(name, ide, date, city, sesi, nick);
			aDao.create(temp);
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
			break;
		}

		}
	}

}
