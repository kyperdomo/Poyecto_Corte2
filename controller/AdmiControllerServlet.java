package co.edu.unbosque.controller;

import java.io.IOException;
import java.sql.Date;

import co.edu.unbosque.model.AlcoholicDTO;
import co.edu.unbosque.model.GeneralServicesDTO;
import co.edu.unbosque.model.PsychologistDTO;
import co.edu.unbosque.model.persistence.AdmiDAO;
import co.edu.unbosque.model.persistence.AlcoholicDAO;
import co.edu.unbosque.model.persistence.GeneralServicesDAO;
import co.edu.unbosque.model.persistence.PsychologistDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdmiControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2273256097367078314L;
	private AdmiDAO aDao;
	private AlcoholicDAO aaDao;
	private GeneralServicesDAO gDao;
	private PsychologistDAO pDao;

	public AdmiControllerServlet() {
		aDao = new AdmiDAO();
		aaDao = new AlcoholicDAO();
		gDao = new GeneralServicesDAO();
		pDao = new PsychologistDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean status = aDao.validate(username, password);
		status = true;
		if (status) {
			RequestDispatcher rd = req.getRequestDispatcher("crudadmi.jsp");
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
			RequestDispatcher rd = req.getRequestDispatcher("createadmi.jsp");
			rd.forward(req, resp);
			break;
		}

		case "read": {
			RequestDispatcher rd = req.getRequestDispatcher("readadmi.jsp");
			rd.forward(req, resp);
			break;
		}
		case "update": {
			RequestDispatcher rd = req.getRequestDispatcher("updateadmi.jsp");
			rd.forward(req, resp);
			break;
		}
		case "delete": {
			RequestDispatcher rd = req.getRequestDispatcher("deleteadmi.jsp");
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
		
		case "Savepsy": {
			String name = req.getParameter("nombre");
			String[] aux = req.getParameter("fechanac").split("/");
			Date date = new Date(Integer.parseInt(aux[0]), Integer.parseInt(aux[0]), Integer.parseInt(aux[0]));
			int ide = Integer.parseInt(req.getParameter("cedula"));
			String city = req.getParameter("ciudad");
			String[] aux1 = req.getParameter("añograd").split("/");
			Date date1 = new Date(Integer.parseInt(aux[0]), Integer.parseInt(aux[0]), Integer.parseInt(aux[0]));
			int day = Integer.parseInt(req.getParameter("diasser"));
			long sesi = Long.parseLong("sesionap");
			int nick = Integer.parseInt("salariop");
			PsychologistDTO temp = new PsychologistDTO(name, ide, date, city, date1, ide, day, nick)
			gDao.create(temp);
			break;
		}

		}
	}

}
