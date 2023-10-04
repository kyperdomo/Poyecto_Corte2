/**
 * package for classes that represent objects
 */
package co.edu.unbosque.model;



/**
 * This class represents a alcoholic with their respective attributes and the
 * attributes inherited from PersonDTO
 */
public class AdmiDTO{

	private String user;
	private String password;
	
	/**
	 * constructor that defines the attributes of this class
	 */
	public AdmiDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * complete constructor that initializes each of the alcoholic's own attributes
	 * 
	 * @param user full name of the person entered
	 * @param password to keep identity in the sistem
	 */
	public AdmiDTO(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
