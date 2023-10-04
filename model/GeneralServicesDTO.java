/**
 * package for classes that represent objects
 */
package co.edu.unbosque.model;

import java.util.Date;

/**
 * This class represents a general services person with their respective
 * attributes and the attributes inherited from PersonDTO
 */
public class GeneralServicesDTO extends PersonDTO {

	private long salary;
	private int sessions;

	/**
	 * constructor that defines the attributes of this class
	 */
	public GeneralServicesDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * complete constructor that initializes each of the general services person own
	 * attributes
	 * 
	 * @param salary   monthly payment for your services provided
	 * @param sessions sessions cleaned
	 */
	public GeneralServicesDTO(long salary, int sessions) {
		super();
		this.salary = salary;
		this.sessions = sessions;
	}

	/**
	 * complete constructor that initializes each of the person's and general
	 * services person's own attributes
	 * 
	 * @param id          indicator assigned by the database
	 * @param name        full name of the person entered
	 * @param ide         a person's own identification number
	 * @param birthdate   day, month and year of birth of a person
	 * @param cityOfBirth geographical place in which the person was born
	 * @param salary      monthly payment for your services provided
	 * @param sessions    sessions cleaned
	 */
	public GeneralServicesDTO(int id, String name, int ide, Date birthdate, String cityOfBirth, long salary,
			int sessions) {
		super(id, name, ide, birthdate, cityOfBirth);
		this.salary = salary;
		this.sessions = sessions;
	}
	
	

	/**
	 * specific constructor that initializes each of the person's and general
	 * services person's own attributes
	 * 
	 * @param name        full name of the person entered
	 * @param ide         a person's own identification number
	 * @param birthdate   day, month and year of birth of a person
	 * @param cityOfBirth geographical place in which the person was born
	 * @param salary      monthly payment for your services provided
	 * @param sessions    sessions cleaned
	 */
	public GeneralServicesDTO(String name, int ide, Date birthdate, String cityOfBirth, long salary, int sessions) {
		super(name, ide, birthdate, cityOfBirth);
		this.salary = salary;
		this.sessions = sessions;
	}

	/**
	 * complete constructor that initializes each of the parent class attributes
	 * 
	 * @param id          indicator assigned by the database
	 * @param name        full name of the person entered
	 * @param ide         a person's own identification number
	 * @param birthdate   day, month and year of birth of a person
	 * @param cityOfBirth geographical place in which the person was born
	 */
	public GeneralServicesDTO(int id, String name, int ide, Date birthdate, String cityOfBirth) {
		super(id, name, ide, birthdate, cityOfBirth);
		// TODO Auto-generated constructor stub
	}

	/**
	 * shows the salary of the general services person
	 * 
	 * @return the salary monthly payment for your services provided
	 */
	public long getSalary() {
		return salary;
	}

	/**
	 * Give value to the salary of the general services person
	 * 
	 * @param salary the salary to set monthly payment for your services provided
	 */
	public void setSalary(long salary) {
		this.salary = salary;
	}

	/**
	 * shows the number of sessions cleaned
	 * 
	 * @return the sessions sessions cleaned
	 */
	public int getSessions() {
		return sessions;
	}

	/**
	 * Give value to the number of sessions cleaned
	 * 
	 * @param sessions the sessions to set sessions cleaned
	 */
	public void setSessions(int sessions) {
		this.sessions = sessions;
	}
	
	/**
	 * returns a string representation of the general services person
	 * 
	 * @return String text string of each attribute of the general services person
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\nNumero de sesiones limpiadas: " + getSessions());
		sb.append("\nSalario: $" + getSalary());
		return sb.toString();
	}
}
