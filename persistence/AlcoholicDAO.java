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
import co.edu.unbosque.model.AlcoholicDTO;

/**
 * This class handles the basic operations that a Alcoholic will have within the
 * application
 * 
 * @author
 */
public class AlcoholicDAO implements CRUDOperation<AlcoholicDTO> {

	private ArrayList<AlcoholicDTO> list;
	private DBConnection dbcon;

	/**
	 * constructor that defines the attributes of this class
	 */
	public AlcoholicDAO() {
		list = new ArrayList<>();
		dbcon = new DBConnection();
	}

	/**
	 * This function is responsible for entering the information from the
	 * application to the database for the correct persistence of the data.
	 * 
	 * @param Object obj It is a alcoholic type object that brings all the
	 *               characteristics of the new participant for manipulation.
	 */
	@Override
	public void create(Object obj) {
		AlcoholicDTO temp = (AlcoholicDTO) obj;
		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement(
					"INSERT INTO alcoholicos (Nombre, fechanacimiento, cedula, ciudadnacimiento,Sesionesparticipadas,Apodo) VALUES (?,?,?,?,?,?);"));
			dbcon.getPreparedStatement().setString(1, temp.getName());
			dbcon.getPreparedStatement().setDate(2, (Date) temp.getBirthdate());
			dbcon.getPreparedStatement().setInt(3, temp.getIde());
			dbcon.getPreparedStatement().setString(4, temp.getCityOfBirth());
			dbcon.getPreparedStatement().setInt(5, temp.getSessions());
			dbcon.getPreparedStatement().setString(6, temp.getNickname());
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (Exception e) {
		}
	}

	/**
	 * The job of this function is to extract the information of a particular
	 * alcoholic.
	 * 
	 * @param index number with which we identify the user who must be show
	 * @return Returns a String with the information of the specific alcoholic
	 */
	@Override
	public Object readOnly(String index) {
		loading();
		for (AlcoholicDTO per : list) {
			if (per.getIde() == Integer.parseInt(index)) {
				return per;
			}
		}
		return null;
	}

	/**
	 * This method is intended to go through all the information available for each
	 * alcoholic who has been added.
	 * 
	 * @return a String with the information of all the alcoholic in the database
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
			dbcon.setResulSet(dbcon.getStatement().executeQuery("SELECT *FROM alcoholicos;"));
			while (dbcon.getResulSet().next()) {
				int id = dbcon.getResulSet().getInt("id");
				String name = dbcon.getResulSet().getString("Nombre");
				Date date = dbcon.getResulSet().getDate("fechanacimiento");
				int ide = dbcon.getResulSet().getInt("cedula");
				String city = dbcon.getResulSet().getString("ciudadnacimiento");
				int sessions = dbcon.getResulSet().getInt("Sesionesparticipadas");
				String nickname = dbcon.getResulSet().getString("Apodo");
				list.add(new AlcoholicDTO(id, name, ide, date, city, sessions, nickname));
			}
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method allows updating the information of a particular alcoholic
	 * 
	 * @param index  unique identification number with which we identify the
	 *               alcoholic who must be updated
	 * @param Object The new information of the alcoholic to update
	 * @return int returns a number indicating the result of the operation
	 */
	@Override
	public int update(int index, Object obj) {
		loading();
		AlcoholicDTO temp = (AlcoholicDTO) obj;
		dbcon.initConnection();
		int id = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIde() == index) {
				id = list.get(i).getId();
			}
		}

		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement(
					"UPDATE alcoholicos SET id=?, Nombre=?, fechanacimiento=?, cedula=?, ciudadnacimiento=?, Sesionesparticipadas=?, Apodo=? WHERE id=?;"));
			dbcon.getPreparedStatement().setInt(1, id);
			dbcon.getPreparedStatement().setString(2, temp.getName());
			dbcon.getPreparedStatement().setDate(3, (Date) temp.getBirthdate());
			dbcon.getPreparedStatement().setInt(4, temp.getIde());
			dbcon.getPreparedStatement().setString(5, temp.getCityOfBirth());
			dbcon.getPreparedStatement().setInt(6, temp.getSessions());
			dbcon.getPreparedStatement().setString(7, temp.getNickname());
			dbcon.getPreparedStatement().setInt(8, id);
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
			return 0;
		} catch (SQLException e) {
			return 1;
		}
	}

	/**
	 * The function of this method is to eliminate the alcoholic that matches the
	 * indicator entered by parameter
	 * 
	 * @param index unique identification number with which we identify the
	 *              alcoholic who must be delete
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
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement("DELETE FROM alcoholicos WHERE id=?;"));
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
		for (AlcoholicDTO a : list) {
			if (a.getNickname().contains(name)) {
				if (a.getIde() == Integer.parseInt(num)) {
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
	public ArrayList<AlcoholicDTO> getList() {
		return list;
	}

	/**
	 * gives a value to the list of alcoholics
	 * 
	 * @param list the list of alcoholic
	 */
	public void setList(ArrayList<AlcoholicDTO> list) {
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
