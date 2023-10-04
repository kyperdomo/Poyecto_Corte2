package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import co.edu.unbosque.model.AlcoholicDTO;
import co.edu.unbosque.model.GeneralServicesDTO;
import co.edu.unbosque.model.persistence.AlcoholicDAO;
import co.edu.unbosque.model.persistence.GeneralServicesDAO;
import co.edu.unbosque.model.persistence.PsychologistDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PsychologistControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7288958262588113807L;
	private PsychologistDAO pDao;
	private AlcoholicDAO aDao;
	private GeneralServicesDAO gDao;

	public PsychologistControllerServlet() {
		pDao = new PsychologistDAO();
		aDao = new AlcoholicDAO();
		gDao = new GeneralServicesDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean status = pDao.validate(username, password);
		if (status) {
			RequestDispatcher rd = req.getRequestDispatcher("crudpsy.jsp");
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
			RequestDispatcher rd = req.getRequestDispatcher("createpsy.jsp");
			rd.forward(req, resp);
			break;
		}

		case "read": {
			RequestDispatcher rd = req.getRequestDispatcher("readpsy.jsp");
			rd.forward(req, resp);
			break;
		}
		case "update": {
			RequestDispatcher rd = req.getRequestDispatcher("updatepsy.jsp");
			rd.forward(req, resp);
			break;
		}
		case "delete": {
			RequestDispatcher rd = req.getRequestDispatcher("deletepsy.jsp");
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

		case "Savegen": {
			String name = req.getParameter("nombre");
			String[] aux = req.getParameter("fechanac").split("/");
			Date date = new Date(Integer.parseInt(aux[0]), Integer.parseInt(aux[0]), Integer.parseInt(aux[0]));
			int ide = Integer.parseInt(req.getParameter("cedula"));
			String city = req.getParameter("ciudad");
			long sesi = Long.parseLong("salario");
			int nick = Integer.parseInt("sesioneslimp");
			GeneralServicesDTO temp = new GeneralServicesDTO(name, ide, date, city, sesi, nick);
			gDao.create(temp);
			break;
		}

		}
	}

}
