package co.edu.unbosque.model.persistence;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.persistence.GeneralServicesDAO;

public class GeneralServicesDAOTest {

	private GeneralServicesDAO generalServicesDAO;

	@Before
	public void setUp() {
		// Inicializar la instancia de GeneralServicesDAO
		generalServicesDAO = new GeneralServicesDAO();
	}

	@Test
	public void testCreateReadAndReadAll() {
		// Prueba de crear un nuevo registro
		generalServicesDAO.create("John Doe", "2023-10-03", "1234567890", "City", "5", "5000");

		// Prueba de lectura del registro recién creado
		String result = generalServicesDAO.readAll();
		assertTrue(result.contains("John Doe"));

		// Prueba de lectura de un registro específico
		result = generalServicesDAO.readOnly(1);
		assertNotNull(result);
		assertTrue(result.contains("John Doe"));
	}

	@Test
	public void testUpdate() {
		// Prueba de crear un nuevo registro
		generalServicesDAO.create("Jane Doe", "2023-10-03", "9876543210", "City", "3", "3000");

		// Prueba de actualización del registro recién creado
		int updateResult = generalServicesDAO.update(1, "Updated Name", "2023-10-04", "1111111111", "Updated City", "4",
				"4000");
		assertEquals(0, updateResult); // Éxito

		// Verificar que los cambios se reflejen en la lectura del registro
		String result = generalServicesDAO.readOnly(1);
		assertNotNull(result);
		assertTrue(result.contains("Updated Name"));
		assertTrue(result.contains("Updated City"));
	}

	@Test
	public void testDelete() {
		// Prueba de crear un nuevo registro
		generalServicesDAO.create("Test User", "2023-10-03", "5555555555", "Test City", "2", "2000");

		// Prueba de eliminación del registro recién creado
		int deleteResult = generalServicesDAO.delete(1);
		assertEquals(0, deleteResult); // Éxito

		// Verificar que el registro se haya eliminado
		String result = generalServicesDAO.readAll();
		assertFalse(result.contains("Test User"));
	}
}
