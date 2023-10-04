/**
 * package for classes that represent objects
 */
package co.edu.unbosque.model;

/**
 * classes or elements implemented for the correct use of the application, imported from the application itself or from Java's own classes
 */
import java.util.Date;

/**
 * This class represents a person with their respective attributes
 */
public class PersonDTO {

	private int id;
	private String name;
	private int ide;
	private Date birthdate;
	private String cityOfBirth;

	/**
	 * constructor that defines the attributes of this class
	 */
	public PersonDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * complete constructor that initializes each of the person's own attributes
	 * 
	 * @param id          indicator assigned by the database
	 * @param name        full name of the person entered
	 * @param ide         a person's own identification number
	 * @param birthdate   day, month and year of birth of a person
	 * @param cityOfBirth geographical place in which the person was born
	 */
	public PersonDTO(int id, String name, int ide, Date birthdate, String cityOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.ide = ide;
		this.birthdate = birthdate;
		this.cityOfBirth = cityOfBirth;
	}

	/**
	 * complete constructor that initializes each of the person's own attributes
	 * 
	 * @param name        full name of the person entered
	 * @param ide         a person's own identification number
	 * @param birthdate   day, month and year of birth of a person
	 * @param cityOfBirth geographical place in which the person was born
	 */
	public PersonDTO(String name, int ide, Date birthdate, String cityOfBirth) {
		super();
		this.name = name;
		this.ide = ide;
		this.birthdate = birthdate;
		this.cityOfBirth = cityOfBirth;
	}
	

	/**
	 * shows the person's indicator
	 * 
	 * @return the id call sign assigned by the database
	 */
	public int getId() {
		return id;
	}

	/**
	 * gives a value to the person indicator
	 * 
	 * @param id the id to set indicator assigned by the database
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * shows the person's proper name
	 * 
	 * @return the name full name of the person entered
	 */
	public String getName() {
		return name;
	}

	/**
	 * gives a value to the person's name
	 * 
	 * @param name the name to set full name of the person entered
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * shows the person's own ID
	 * 
	 * @return the ide a person's own identification number
	 */
	public int getIde() {
		return ide;
	}

	/**
	 * gives a value to the person's identity number
	 * 
	 * @param ide the ide to set a person's own identification number
	 */
	public void setIde(int ide) {
		this.ide = ide;
	}

	/**
	 * shows the person's own date of birth
	 * 
	 * @return the birthdate day, month and year of birth of a person
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * gives a value to the person's birthday
	 * 
	 * @param birthdate the birthdate to set day, month and year of birth of a
	 *                  person
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * shows the person's own birthplace
	 * 
	 * @return the cityOfBirth geographical place in which the person was born
	 */
	public String getCityOfBirth() {
		return cityOfBirth;
	}

	/**
	 * gives a value to the person's place of birth
	 * 
	 * @param cityOfBirth the cityOfBirth to set geographical place in which the
	 *                    person was born
	 */
	public void setCityOfBirth(String cityOfBirth) {
		this.cityOfBirth = cityOfBirth;
	}

	/**
	 * returns a string representation of the person
	 * 
	 * @return String text string of each attribute of the person
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + getId());
		sb.append("\nNombre: " + getName());
		sb.append("\nNumero de identificación: " + getIde());
		sb.append("\nFecha de cumpleaños: " + getBirthdate());
		sb.append("\nLugar de nacimiento: " + getCityOfBirth());
		return sb.toString();
	}

}
