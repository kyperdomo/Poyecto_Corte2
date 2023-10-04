/**
 * package for classes that represent objects
 */
package co.edu.unbosque.model;

/**
 * classes or elements implemented for the correct use of the application, imported from the application itself or from Java's own classes
 */
import java.util.Date;

/**
 * This class represents a alcoholic with their respective attributes and the
 * attributes inherited from PersonDTO
 */
public class AlcoholicDTO extends PersonDTO {

	private int sessions;
	private String nickname;

	/**
	 * constructor that defines the attributes of this class
	 */
	public AlcoholicDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * complete constructor that initializes each of the alcoholic's own attributes
	 * 
	 * @param sessions number of sessions carried out
	 * @param nickname nickname to keep identity anonymous
	 */
	public AlcoholicDTO(int sessions, String nickname) {
		super();
		this.sessions = sessions;
		this.nickname = nickname;
	}

	/**
	 * complete constructor that initializes each of the person's and alcoholic's
	 * own attributes
	 * 
	 * @param id          indicator assigned by the database
	 * @param name        full name of the person entered
	 * @param ide         a person's own identification number
	 * @param birthdate   day, month and year of birth of a person
	 * @param cityOfBirth geographical place in which the person was born
	 * @param sessions    number of sessions carried out
	 * @param nickname    nickname to keep identity anonymous
	 */
	public AlcoholicDTO(int id, String name, int ide, Date birthdate, String cityOfBirth, int sessions,
			String nickname) {
		super(id, name, ide, birthdate, cityOfBirth);
		this.sessions = sessions;
		this.nickname = nickname;
	}

	/**
	 * complete constructor that initializes each of the person's and alcoholic's
	 * own attributes
	 * 
	 * @param name        full name of the person entered
	 * @param ide         a person's own identification number
	 * @param birthdate   day, month and year of birth of a person
	 * @param cityOfBirth geographical place in which the person was born
	 * @param sessions    number of sessions carried out
	 * @param nickname    nickname to keep identity anonymous
	 */
	public AlcoholicDTO(String name, int ide, Date birthdate, String cityOfBirth, int sessions, String nickname) {
		super(name, ide, birthdate, cityOfBirth);
		this.sessions = sessions;
		this.nickname = nickname;
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
	public AlcoholicDTO(int id, String name, int ide, Date birthdate, String cityOfBirth) {
		super(id, name, ide, birthdate, cityOfBirth);
		// TODO Auto-generated constructor stub
	}

	/**
	 * shows the number of sessions in which the alcoholic has participated
	 * 
	 * @return the sessions number of sessions carried out
	 */
	public int getSessions() {
		return sessions;
	}

	/**
	 * gives a value to the number of sessions attended by the alcoholic.
	 * 
	 * @param sessions the sessions to set number of sessions carried out
	 */
	public void setSessions(int sessions) {
		this.sessions = sessions;
	}

	/**
	 * shows the nickname of the alcoholic
	 * 
	 * @return the nickname nickname to keep identity anonymous
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Give value to the alcoholic's nickname.
	 * 
	 * @param nickname the nickname to set nickname to keep identity anonymous
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * returns a string representation of the alcoholic
	 * 
	 * @return String text string of each attribute of the alcoholic
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\nSesiones participadas : " + getSessions());
		sb.append("\nApodo: " + getNickname());
		return sb.toString();
	}
}
