/**
 * package to save data and actions that should be persisted
 */
package co.edu.unbosque.model.persistence;

/**
 * This interface establishes the actions that each type of user must have
 * within the application
 * 
 * @param <E> indicates what type of user is going to be used
 */
public interface CRUDOperation<E> {

	/**
	 * This function is responsible for entering the information from the
	 * application to the database for the correct persistence of the data.
	 *
	 * @param It is a user type object that brings all the characteristics of the
	 *        new participant for manipulation.
	 */
	public void create(Object obj);

	/**
	 * The job of this function is to extract the information of a particular user
	 * 
	 * @param String number with which we identify the user who must be show
	 * @return Returns a String with the specific user information
	 */
	public Object readOnly(String index);

	/**
	 * This method is intended to go through all the information available for each
	 * user that has been added.
	 * 
	 * @return returns a String with the information of all existing users in the
	 *         database
	 */
	public String readAll();

	/**
	 * loads data from the database to an internal list for easy data manipulation
	 */
	public void loading();

	/**
	 * This method allows updating the information of a particular user
	 * 
	 * @param index  number with which we identify the user who must be updated
	 * @param Object The new information of the user to update
	 * @return int returns a number indicating the result of the operation
	 */
	public int update(int index, Object obj);

	/**
	 * The function of this method is to eliminate the user that matches the
	 * callsign entered by parameter
	 * 
	 * @param index number with which we identify the person who must be delete
	 * @return int returns a number indicating the result of the operation
	 */
	public int delete(int index);

}
