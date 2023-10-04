package co.edu.unbosque.model.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.model.persistence.PersonDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.enterprise.context.BeforeDestroyed;

public class PersonDAOTest {

	private DBConnection dbtcon;
	private PersonDAO perDAO;

	@Before

	public void setUp() {
		dbtcon = new DBConnection();
		perDAO = new PersonDAO();
		ArrayList<PersonDTO> lisp = new ArrayList<>();
		PersonDTO perDAO1 = new PersonDTO(1, "Sofia", 1002565450, new Date(0), "Turmeque");
		lisp.add(perDAO1);

		PersonDTO perDAO2 = new PersonDTO(2, "Juan", 1002789450, new Date(0), "Bogota");
		lisp.add(perDAO2);
		perDAO.setList(lisp);
	}

	@Test
	public void createTest() throws Exception {
		String name = "Sofia";
		Date birthdate = new Date();
		int ide = 1002565450;
		String cityOrigin = "Turmeque";
		dbtcon.create(name, birthdate, ide, cityOrigin);
		Connection con = dbtcon.getConnect();
		PreparedStatement preparedStatement = con.prepareStatement(
				"INSERT INTO personas (Nombre, fechanacimiento, cedula, ciudadnacimiento) VALUES(?, ?, ?, ?);");
		preparedStatement.setString(1, name);
		preparedStatement.setDate(2, birthdate);
		preparedStatement.setInt(3, ide);
		preparedStatement.setString(4, cityOrigin);
		int rowError = preparedStatement.executeUpdate();
		if (rowError == 1) {
			System.out.println("Vamos bien");

		} else {
			System.out.println("Algo anda mal");
		}

	}

	@Test

	public void readIndex() {
		String rest = perDAO.readOnly(1);

		assertEquals(
				"PersonDTO{ide=1, name='Sofia',fechaNacimiento= Tue Jan 01 00:00:00 GMT-05:00 1970, cedula=1002565450,ciudadNacimiento='Turmeque'}",
				rest);
	}

	@Test

	public void readIndexFailed() {
		String rest = perDAO.readOnly(4);
		assertNull(rest);
	}

	@Test
	public void testUpdate() {
		PersonDAO.create("John Doe", "1990-01-15", "12345", "City");
		int personId = 1;

		int result;
		try {
			result = PersonDAO.update(personId, "Updated Name", "1980-02-10", "54321", "New City");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(0, result);

		String updatedInfo = PersonDAO.readOnly(personId);

		assertTrue(updatedInfo.contains("Updated Name"));
		assertTrue(updatedInfo.contains("New City"));
	}

	@Test
	public void testDelete() {
		personDAO.create("John Doe", "1990-01-15", "12345", "City");
		int personId = 1;

		int result = PersonDAO.delete(personId);

		assertEquals(0, result);

		String deletedInfo = PersonDAO.readAll();

		assertFalse(deletedInfo.contains("John Doe"));
	}

	@Test
	public void testReadDate() {
		String dateString = "1990-01-15";

		Date date = PersonDAO.readDate(dateString);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(date);

		assertEquals(dateString, formattedDate);
	}

	@Test
	public void testGetAndSetList() {
		ArrayList<PersonDTO> newList = new ArrayList<>();
		PersonDTO person = new PersonDTO(1, "John Doe", 12345, new Date(0), "City");
		newList.add(person);

		PersonDAO.setList(newList);

		ArrayList<PersonDTO> retrievedList = PersonDAO.getList();

		assertEquals(newList, retrievedList);
	}
}
