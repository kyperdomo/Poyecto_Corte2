/**
 * package to save data and actions that should be persisted
 */
package co.edu.unbosque.model.persistence;

/**
 * classes or elements implemented for the correct use of the application, imported from the application itself or from Java's own classes
 */
import java.sql.SQLException;
import java.util.ArrayList;
import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.AdmiDTO;

public class AdmiDAO {
	private ArrayList<AdmiDTO> list;
	private DBConnection dbcon;

	public AdmiDAO() {
		list = new ArrayList<>();
		dbcon = new DBConnection();
	}

	/**
	 * This function is responsible for entering the information from the
	 * application to the database for the correct persistence of the data.
	 * 
	 * @param Object obj It is a admi type object that brings all the
	 *               characteristics of the new participant for manipulation.
	 */
	public void create(Object obj) {
		AdmiDTO temp = (AdmiDTO) obj;
		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect()
					.prepareStatement("INSERT INTO administradores (usuario, contraseña) VALUES (?,?);"));
			dbcon.getPreparedStatement().setString(1, temp.getUser());
			dbcon.getPreparedStatement().setString(2, temp.getPassword());
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (Exception e) {
		}
	}

	/**
	 * loads data from the database to an internal list for easy data manipulation
	 */
	public void loading() {
		list.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResulSet(dbcon.getStatement().executeQuery("SELECT *FROM administradores;"));
			while (dbcon.getResulSet().next()) {
				String user = dbcon.getResulSet().getString("usuario");
				String pass = dbcon.getResulSet().getString("contraseña");
				list.add(new AdmiDTO(user, pass));
			}
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method checks if the data that the user is entering exists within the
	 * database
	 * 
	 * @param name nickname entered by user
	 * @param num  identity number entered by the user
	 * @return the result of the comparison
	 */
	public boolean validate(String name, String num) {
		loading();
		for (AdmiDTO a : list) {
			if (a.getUser().contains(name)) {
				if (a.getPassword().equals(num)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * shows the complete list with all the alcoholic entered
	 * 
	 * @return the list of alcoholic
	 */
	public ArrayList<AdmiDTO> getList() {
		return list;
	}

	/**
	 * gives a value to the list of alcoholics
	 * 
	 * @param list the list of alcoholic
	 */
	public void setList(ArrayList<AdmiDTO> list) {
		this.list = list;
	}

	/**
	 * shows connection
	 * 
	 * @return the dbcon connection to the database
	 */
	public DBConnection getDbcon() {
		return dbcon;
	}

	/**
	 * gives a value to the connection
	 * 
	 * @param dbcon the dbcon to set connection to the database
	 */
	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}

}
