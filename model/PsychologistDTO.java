/**
 * package for classes that represent objects
 */
package co.edu.unbosque.model;

/**
 * classes or elements implemented for the correct use of the application, imported from the application itself or from Java's own classes
 */
import java.util.Date;

/**
 * This class represents a Psychologist with their respective attributes and the
 * attributes inherited from PersonDTO
 */
public class PsychologistDTO extends PersonDTO {
	private Date graduation;
	private int service;
	private int sessions;
	private long salary;

	/**
	 * constructor that defines the attributes of this class
	 */
	public PsychologistDTO() {

	}

	/**
	 * complete constructor that initializes each of the psychologist's own
	 * attributes
	 *
	 * @param graduation Graduation Year
	 * @param service    days in which he has been serving as a psychologist at the
	 *                   facilities
	 * @param sessions   sessions that he has accompanied during his service
	 * @param salary     monthly payment for your services provided
	 */
	public PsychologistDTO(Date graduation, int service, int sessions, long salary) {
		super();
		this.graduation = graduation;
		this.service = service;
		this.sessions = sessions;
		this.salary = salary;
	}

	/**
	 * complete constructor that initializes each of the person's and psychologist's
	 * own attributes
	 * 
	 * @param id          indicator assigned by the database
	 * @param name        full name of the person entered
	 * @param ide         a person's own identification number
	 * @param birthdate   day, month and year of birth of a person
	 * @param cityOfBirth geographical place in which the person was born
	 * @param graduation  Graduation Year
	 * @param service     days in which he has been serving as a psychologist at the
	 *                    facilities
	 * @param sessions    sessions that he has accompanied during his service
	 * @param salary      monthly payment for your services provided
	 */
	public PsychologistDTO(int id, String name, int ide, Date birthdate, String cityOfBirth, Date graduation,
			int service, int sessions, long salary) {
		super(id, name, ide, birthdate, cityOfBirth);
		this.graduation = graduation;
		this.service = service;
		this.sessions = sessions;
		this.salary = salary;
	}
	
	

	/**
	 * specific constructor that initializes each of the person's and psychologist's
	 * own attributes
	 * 
	 * @param name        full name of the person entered
	 * @param ide         a person's own identification number
	 * @param birthdate   day, month and year of birth of a person
	 * @param cityOfBirth geographical place in which the person was born
	 * @param graduation  Graduation Year
	 * @param service     days in which he has been serving as a psychologist at the
	 *                    facilities
	 * @param sessions    sessions that he has accompanied during his service
	 * @param salary      monthly payment for your services provided
	 */
	public PsychologistDTO(String name, int ide, Date birthdate, String cityOfBirth, Date graduation, int service,
			int sessions, long salary) {
		super(name, ide, birthdate, cityOfBirth);
		this.graduation = graduation;
		this.service = service;
		this.sessions = sessions;
		this.salary = salary;
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
	public PsychologistDTO(int id, String name, int ide, Date birthdate, String cityOfBirth) {
		super(id, name, ide, birthdate, cityOfBirth);
		// TODO Auto-generated constructor stub
	}

	/**
	 * shows the date of graduation of the psychologist
	 * 
	 * @return the graduation Graduation Year
	 */
	public Date getGraduation() {
		return graduation;
	}

	/**
	 * Give value to the psychologist's date of graduation
	 * 
	 * @param graduation the graduation to set
	 */
	public void setGraduation(Date graduation) {
		this.graduation = graduation;
	}

	/**
	 * shows the days serving as a psychologist
	 * 
	 * @return the service days in which he has been serving as a psychologist at
	 *         the facilities
	 */
	public int getService() {
		return service;
	}

	/**
	 * give value to the psychologist's service days.
	 * 
	 * @param service the service to set days in which he has been serving as a
	 *                psychologist at the facilities
	 */
	public void setService(int service) {
		this.service = service;
	}

	/**
	 * shows the number of sessions in which the psychologist has participated
	 * 
	 * @return the sessions number of sessions in which the psychologist has participated
	 */
	public int getSessions() {
		return sessions;
	}

	/**
	 * Give value to sessions in which the psychologist has participated
	 * 
	 * @param sessions the sessions to set number of sessions in which the psychologist has participated
	 */
	public void setSessions(int sessions) {
		this.sessions = sessions;
	}

	/**
	 * shows the salary of the psychologist
	 * 
	 * @return the salary monthly payment for your services provided
	 */
	public long getSalary() {
		return salary;
	}

	/**
	 * Give value to the salary of the psychologist
	 * 
	 * @param salary the salary to set monthly payment for your services provided
	 */
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	/**
	 * returns a string representation of the psychologist's
	 * 
	 * @return String text string of each attribute of the psychologist
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\nAño de graduacion : " + getGraduation());
		sb.append("\nDias de servicio : " + getService());
		sb.append("\nNumero de sesiones apoyadas : " + getSessions());
		sb.append("\nSalario $: " + getSalary());
		return sb.toString();
	}
}
