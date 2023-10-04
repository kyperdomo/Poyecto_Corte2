//arreglar los nombre de las tablas
//Arreglar las columnas de las tablas
//Falta el leer individual
//Arreglar fechas

/**
 * package to save data and actions that should be persisted
 */
package co.edu.unbosque.model.persistence;

/**
 * classes or elements implemented for the correct use of the application, imported from the application itself or from Java's own classes
 */
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.PersonDTO;

/**
 * This class handles the basic operations that a person will have within the
 * application
 * 
 * @author
 */
public class PersonDAO implements CRUDOperation<PersonDTO> {

	private ArrayList<PersonDTO> list;
	private DBConnection dbcon;

	/**
	 * constructor that defines the attributes of this class
	 */
	public PersonDAO() {
		list = new ArrayList<>();
		dbcon = new DBConnection();
	}

	/**
	 * This function is responsible for entering the information from the
	 * application to the database for the correct persistence of the data.
	 * 
	 * @param Objecto obj It is a person type object that brings all the
	 *                characteristics of the new participant for manipulation.
	 */
	@Override
	public void create(Object obj) {
		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement(
					"INSERT INTO personas (Nombre, fechanacimiento, cedula, ciudadnacimiento) VALUES(?, ?, ?, ?);"));
//			dbcon.getPreparedStatement().setString(1, args[0]);
//			dbcon.getPreparedStatement().setDate(2, readDate(args[1]));
//			dbcon.getPreparedStatement().setInt(3, Integer.parseInt(args[2]));
//			dbcon.getPreparedStatement().setString(4, args[3]);
//			dbcon.getPreparedStatement().executeUpdate();
//			dbcon.close();
		} catch (Exception e) {
		}
	}

	/**
	 * The job of this function is to extract the information of a particular
	 * person.
	 * 
	 * @param index number with which we identify the user who must be show
	 * @return Returns a String with the information of the specific person
	 */
	@Override
	public Object readOnly(String index) {
		loading();
		for (PersonDTO per : list) {
			if (per.getIde() == Integer.parseInt(index)) {
				return per;
			}
		}
		return null;
	}

	/**
	 * This method is intended to go through all the information available for each
	 * person who has been added.
	 * 
	 * @return a String with the information of all the people in the database
	 */
	@Override
	public String readAll() {
		loading();
		return list.toString();
	}

	/**
	 * loads data from the database to an internal list for easy data manipulation
	 */
	@Override
	public void loading() {
		list.clear();
		dbcon.initConnection();
		try {
			dbcon.setStatement(dbcon.getConnect().createStatement());
			dbcon.setResulSet(dbcon.getStatement().executeQuery("SELECT *FROM personas;"));
			while (dbcon.getResulSet().next()) {
				int id = dbcon.getResulSet().getInt("id");
				String name = dbcon.getResulSet().getString("Nombre");
				Date date = dbcon.getResulSet().getDate("fechanacimiento");
				int ide = dbcon.getResulSet().getInt("cedula");
				String city = dbcon.getResulSet().getString("ciudadnacimiento");
				list.add(new PersonDTO(id, name, ide, date, city));
			}
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method allows updating the information of a particular person
	 * 
	 * @param index  unique identification number with which we identify the person
	 *               who must be updated
	 * @param String The new information of the person to update
	 * @return int returns a number indicating the result of the operation
	 */
	@Override
	public int update(int index, Object obj) {
		loading();
		dbcon.initConnection();
		int id = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIde() == index) {
				id = list.get(i).getId();
			}
		}

		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement(
					"UPDATE personas SET id=?, Nombre=?, fechanacimiento=?, cedula=?, ciudadnacimiento=? WHERE id=?;"));
//			dbcon.getPreparedStatement().setInt(1, id);
//			dbcon.getPreparedStatement().setString(2, args[0]);
//			dbcon.getPreparedStatement().setDate(3, readDate(args[1]));
//			dbcon.getPreparedStatement().setInt(4, Integer.parseInt(args[2]));
//			dbcon.getPreparedStatement().setString(5, args[3]);
//			dbcon.getPreparedStatement().setInt(6, id);
//			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
			return 0;
		} catch (SQLException e) {
			return 1;
		}
	}

	/**
	 * The function of this method is to eliminate the person that matches the
	 * callsign entered by parameter
	 * 
	 * @param index unique identification number with which we identify the person
	 *              who must be delete
	 * @return int returns a number indicating the result of the operation
	 */
	@Override
	public int delete(int index) {
		loading();
		int id = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIde() == index) {
				id = list.get(i).getId();
			}
		}

		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement("DELETE FROM personas WHERE id=?;"));
			dbcon.getPreparedStatement().setInt(1, id);
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
			return 0;
		} catch (SQLException e) {
			return 1;
		}
	}

	/**
	 * performs the necessary operations to return the date of birth in the
	 * appropriate format
	 * 
	 * @param fecha the String of the date entered by the user
	 * @return Date the date in the format necessary to enter the database
	 */
	public Date readDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		Date temp = null;

		try {
			temp = (Date) format.parse(date);
		} catch (ParseException e) {
		}
		return temp;
	}

	/**
	 * shows the complete list with all the people entered
	 * 
	 * @return the list of person
	 */
	public ArrayList<PersonDTO> getList() {
		return list;
	}

	/**
	 * gives a value to the list of people
	 * 
	 * @param list the list of person
	 */
	public void setList(ArrayList<PersonDTO> list) {
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
