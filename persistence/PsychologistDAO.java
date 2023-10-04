/**
 * package to save data and actions that should be persisted
 */
package co.edu.unbosque.model.persistence;

/**
 * classes or elements implemented for the correct use of the application, imported from the application itself or from Java's own classes
 */
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.PsychologistDTO;

/**
 * This class handles the basic operations that a Psychologist will have within
 * the application
 * 
 * @author
 */
public class PsychologistDAO implements CRUDOperation<PsychologistDTO> {

	private ArrayList<PsychologistDTO> list;
	private DBConnection dbcon;

	/**
	 * constructor that defines the attributes of this class
	 */
	public PsychologistDAO() {
		list = new ArrayList<>();
		dbcon = new DBConnection();
	}

	/**
	 * This function is responsible for entering the information from the
	 * application to the database for the correct persistence of the data.
	 * 
	 * @param Object obj It is a psychologist type object that brings all the
	 *               characteristics of the new participant for manipulation.
	 */
	@Override
	public void create(Object obj) {
		PsychologistDTO temp = (PsychologistDTO) obj;
		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement(
					"INSERT INTO psicologos (Nombre, fechanacimiento, cedula, ciudadnacimiento, añograduacion, diasservicio, Sesionesapoyadas, salario) VALUES(?, ?, ?, ?, ?, ?, ?, ?);"));
			dbcon.getPreparedStatement().setString(1, temp.getName());
			dbcon.getPreparedStatement().setDate(2, (Date) temp.getBirthdate());
			dbcon.getPreparedStatement().setInt(3, temp.getIde());
			dbcon.getPreparedStatement().setString(4, temp.getCityOfBirth());
			dbcon.getPreparedStatement().setLong(5, temp.getGraduation().getYear());
			dbcon.getPreparedStatement().setInt(6, temp.getService());
			dbcon.getPreparedStatement().setInt(7, temp.getSessions());
			dbcon.getPreparedStatement().setLong(8, temp.getSalary());
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (Exception e) {
		}
	}

	/**
	 * The job of this function is to extract the information of a particular
	 * psychologist.
	 * 
	 * @param index number with which we identify the user who must be show
	 * @return Returns a String with the information of the specific psychologist
	 */
	@Override
	public Object readOnly(String index) {
		loading();
		for (PsychologistDTO per : list) {
			if (per.getIde() == Integer.parseInt(index)) {
				return per;
			}
		}
		return null;
	}

	/**
	 * This method is intended to go through all the information available for each
	 * psychologist who has been added.
	 * 
	 * @return a String with the information of all the psychologist in the database
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
			dbcon.setResulSet(dbcon.getStatement().executeQuery("SELECT *FROM psicologos;"));
			while (dbcon.getResulSet().next()) {
				int id = dbcon.getResulSet().getInt("id");
				String name = dbcon.getResulSet().getString("Nombre");
				Date date = dbcon.getResulSet().getDate("fechanacimiento");
				int ide = dbcon.getResulSet().getInt("cedula");
				String city = dbcon.getResulSet().getString("ciudadnacimiento");
				Date year = dbcon.getResulSet().getDate("añograduacion");
				int day = dbcon.getResulSet().getInt("diasservicio");
				int session = dbcon.getResulSet().getInt("Sesionesapoyadas");
				long mon = dbcon.getResulSet().getLong("salario");
				list.add(new PsychologistDTO(id, name, ide, date, city, year, day, session, mon));
			}
			dbcon.close();
		} catch (SQLException e) {
		}

	}

	/**
	 * This method allows updating the information of a particular psychologist
	 * 
	 * @param index  unique identification number with which we identify the
	 *               psychologist who must be updated
	 * @param Object The new information of the psychologist to update
	 * @return int returns a number indicating the result of the operation
	 */
	@Override
	public int update(int index, Object obj) {
		loading();
		PsychologistDTO temp = (PsychologistDTO) obj;
		dbcon.initConnection();
		int id = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIde() == index) {
				id = list.get(i).getId();
			}
		}

		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement(
					"UPDATE psicologos SET id=?, Nombre=?, fechanacimiento=?, cedula=?, ciudadnacimiento=?, añograduacion=?, diasservicio=?, Sesionesapoyadas=?, salario=? WHERE id=?;"));
			dbcon.getPreparedStatement().setInt(1, id);
			dbcon.getPreparedStatement().setDate(2, (Date) temp.getBirthdate());
			dbcon.getPreparedStatement().setInt(3, temp.getIde());
			dbcon.getPreparedStatement().setString(4, temp.getCityOfBirth());
			dbcon.getPreparedStatement().setLong(5, temp.getGraduation().getYear());
			dbcon.getPreparedStatement().setInt(6, temp.getService());
			dbcon.getPreparedStatement().setInt(7, temp.getSessions());
			dbcon.getPreparedStatement().setLong(8, temp.getSalary());
			dbcon.getPreparedStatement().setInt(10, id);
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
			return 0;
		} catch (SQLException e) {
			return 1;
		}
	}

	/**
	 * The function of this method is to eliminate the psychologist that matches the
	 * indicator entered by parameter
	 * 
	 * @param index unique identification number with which we identify the
	 *              psychologist who must be delete
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
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement("DELETE FROM psicologos WHERE id=?;"));
			dbcon.getPreparedStatement().setInt(1, id);
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
			return 0;
		} catch (SQLException e) {
			return 1;
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
		for (PsychologistDTO a : list) {
			if (a.getName().contains(name)) {
				if (a.getIde() == Integer.parseInt(num)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * shows the complete list with all the psychologist entered
	 * 
	 * @return the list of psychologist
	 */
	public ArrayList<PsychologistDTO> getList() {
		return list;
	}

	/**
	 * gives a value to the list of psychologist
	 * 
	 * @param list the list of psychologist
	 */
	public void setList(ArrayList<PsychologistDTO> list) {
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
