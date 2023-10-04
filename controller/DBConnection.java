/**
 * package in charge of the connection between the other packages
 */
package co.edu.unbosque.controller;

/**
 * classes or elements implemented for the correct use of the application, imported from the application itself or from Java's own classes
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * class responsible for establishing a connection with the database created for
 * this project
 */
public class DBConnection {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resulSet = null;
	private final String IP = "35.239.57.35";
	private final String PORT = "3306";
	private final String DATABASE = "montañoDanna";
	private final String USERNAME = "root";
	private final String PASSWORD = "programacion2";

	/**
	 * constructor that defines the attributes of this class
	 */
	public DBConnection() {
	}

	/**
	 * Establishes a connection with MySQL using the information provided to enter
	 * the database
	 */
	public void initConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE, USERNAME,
					PASSWORD);
			if (connect != null) {
				System.out.println("Accion realizada con exito");
			}
		} catch (ClassNotFoundException e) {

		} catch (SQLException ee) {

		}
	}

	/**
	 * closes the use of all connections and releases them for free use by the
	 * entire project
	 */
	public void close() {
		try {
			if (resulSet != null) {
				resulSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}

		} catch (Exception e) {
		}
	}

	/**
	 * @return the connect
	 */
	public Connection getConnect() {
		return connect;
	}

	/**
	 * @param connect the connect to set
	 */
	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	/**
	 * @return the statement
	 */
	public Statement getStatement() {
		return statement;
	}

	/**
	 * @param statement the statement to set
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	/**
	 * @return the preparedStatement
	 */
	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	/**
	 * @param preparedStatement the preparedStatement to set
	 */
	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	/**
	 * @return the resulSet
	 */
	public ResultSet getResulSet() {
		return resulSet;
	}

	/**
	 * @param resulSet the resulSet to set
	 */
	public void setResulSet(ResultSet resulSet) {
		this.resulSet = resulSet;
	}

	/**
	 * @return the iP
	 */
	public String getIP() {
		return IP;
	}

	/**
	 * @return the pORT
	 */
	public String getPORT() {
		return PORT;
	}

	/**
	 * @return the dATABASE
	 */
	public String getDATABASE() {
		return DATABASE;
	}

	/**
	 * @return the uSERNAME
	 */
	public String getUSERNAME() {
		return USERNAME;
	}

	/**
	 * @return the pASSWORD
	 */
	public String getPASSWORD() {
		return PASSWORD;
	}

}
