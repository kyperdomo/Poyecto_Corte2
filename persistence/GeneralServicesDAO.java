/**
 * package to save data and actions that should be persisted
 */
package co.edu.unbosque.model.persistence;

/**
 * classes or elements implemented for the correct use of the application, imported from the application itself or from Java's own classes
 */
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import co.edu.unbosque.controller.DBConnection;
import co.edu.unbosque.model.GeneralServicesDTO;

/**
 * This class handles the basic operations that a general services person will
 * have within the application
 * 
 * @author
 */
public class GeneralServicesDAO implements CRUDOperation<GeneralServicesDTO> {
	private ArrayList<GeneralServicesDTO> list;
	private DBConnection dbcon;

	/**
	 * constructor that defines the attributes of this class
	 */
	public GeneralServicesDAO() {
		list = new ArrayList<>();
		dbcon = new DBConnection();
	}

	/**
	 * This function is responsible for entering the information from the
	 * application to the database for the correct persistence of the data.
	 * 
	 * @param String args The parameter of this method is an argument that is an
	 *               array of type String, this parameter contains the attributes
	 *               that the user has entered about the general services person.
	 */
	@Override
	public void create(Object obj) {
		GeneralServicesDTO temp = (GeneralServicesDTO)obj;
		dbcon.initConnection();
		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement(
					"INSERT INTO serviciosgenrales (Nombre, fecha, cedula, ciudadorigen, Sesioneslimpiadas, salario) VALUES(?, ?, ?, ?, ?, ?);"));
			dbcon.getPreparedStatement().setString(1, temp.getName());
			dbcon.getPreparedStatement().setDate(2, (Date) temp.getBirthdate());
			dbcon.getPreparedStatement().setInt(3, temp.getIde());
			dbcon.getPreparedStatement().setString(4, temp.getCityOfBirth());
			dbcon.getPreparedStatement().setInt(5, temp.getSessions());
			dbcon.getPreparedStatement().setLong(6, temp.getSalary());
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
		} catch (Exception e) {
		}

	}

	/**
	 * The job of this function is to extract the information of a particular
	 * general services person.
	 * 
	 * @param index number with which we identify the general services person who
	 *              must be show
	 * @return Returns a String with the information of the specific general
	 *         services person
	 */
	@Override
	public Object readOnly(String index) {
		loading();
		for (GeneralServicesDTO per : list) {
			if (per.getIde() == Integer.parseInt(index)) {
				return per;
			}
		}
		return null;
	}

	/**
	 * This method is intended to go through all the information available for each
	 * general services person who has been added.
	 * 
	 * @return a String with the information of all the general services person in
	 *         the database
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
			dbcon.setResulSet(dbcon.getStatement().executeQuery("SELECT *FROM serviciosgenrales;"));
			while (dbcon.getResulSet().next()) {
				int id = dbcon.getResulSet().getInt("id");
				String name = dbcon.getResulSet().getString("Nombre");
				Date date = dbcon.getResulSet().getDate("fecha");
				int ide = dbcon.getResulSet().getInt("cedula");
				String city = dbcon.getResulSet().getString("ciudadorigen");
				int session = dbcon.getResulSet().getInt("Sesioneslimpiadas");
				long mon = dbcon.getResulSet().getLong("salario");
				list.add(new GeneralServicesDTO(id, name, ide, date, city, mon, session));
			}
			dbcon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method allows updating the information of a particular general services
	 * person
	 * 
	 * @param index  unique identification number with which we identify the general
	 *               services person who must be updated
	 * @param Object The new information of the general services person to update
	 * @return int returns a number indicating the result of the operation
	 */
	@Override
	public int update(int index, Object obj) {
		loading();
		GeneralServicesDTO temp = (GeneralServicesDTO)obj;
		dbcon.initConnection();
		int id = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIde() == index) {
				id = list.get(i).getId();
			}
		}

		try {
			dbcon.setPreparedStatement(dbcon.getConnect().prepareStatement(
					"UPDATE serviciosgenrales SET id=?, Nombre=?, fecha=?, cedula=?, ciudadorigen=?, Sesioneslimpiadas=?, salario=? WHERE id=?;"));
			dbcon.getPreparedStatement().setInt(1, id);
			dbcon.getPreparedStatement().setString(2, temp.getName());
			dbcon.getPreparedStatement().setDate(3, (Date) temp.getBirthdate());
			dbcon.getPreparedStatement().setInt(4, temp.getIde());
			dbcon.getPreparedStatement().setString(5, temp.getCityOfBirth());
			dbcon.getPreparedStatement().setInt(6, temp.getSessions());
			dbcon.getPreparedStatement().setLong(7, temp.getSalary());
			dbcon.getPreparedStatement().setLong(8, id);
			dbcon.getPreparedStatement().executeUpdate();
			dbcon.close();
			return 0;
		} catch (SQLException e) {
			return 1;
		}
	}

	/**
	 * The function of this method is to eliminate the general services person that
	 * matches the indicator entered by parameter
	 * 
	 * @param index unique identification number with which we identify the
	 *              psychologist who must be delete
	 * @return int returns a number indicating the result of the operation
	 */
	@Override
	public int delete(int index) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * This method checks if the data that the user is entering exists within the database
	 * 
	 * @param name nickname entered by user
	 * @param num identity number entered by the user
	 * @return the result of the comparison
	 */
	public boolean validate(String name, String num) {
		loading();
		for (GeneralServicesDTO a : list) {
			if (a.getName().contains(name)) {
				if (a.getIde() == Integer.parseInt(num)) {
					return true;
				} 
			}
		}
		return false;
	}

	/**
	 * shows the complete list with all the general services person
	 * 
	 * @return the list of general services person
	 */
	public ArrayList<GeneralServicesDTO> getList() {
		return list;
	}

	/**
	 * gives a value to the list of general services person
	 * 
	 * @param list the list of general services person
	 */
	public void setList(ArrayList<GeneralServicesDTO> list) {
		this.list = list;
	}

	/**
	 * shows connection to the connection database
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
