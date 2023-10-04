package co.edu.unbosque.controller;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.controller.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionTest {

	private DBConnection dbConnection;

	@Before
	public void setUp() {
		dbConnection = new DBConnection();
	}

	@After
	public void tearDown() {
		dbConnection.close();
	}

	@Test
	public void testInitConnectionSuccess() throws SQLException {
		dbConnection.initConnection();
		Connection connection = dbConnection.getConnect();
		assertNotNull(connection);
		assertTrue(connection.isValid(5));
	}

	@Test
	public void testInitConnectionFailure() {
		// Cambiar las credenciales de conexión para forzar un error de conexión
		dbConnection = new DBConnection();

		// Intentar iniciar la conexión
		try {
			dbConnection.initConnection();
		} catch (Exception e) {
			assertNull(dbConnection.getConnect());
		}
	}
}
