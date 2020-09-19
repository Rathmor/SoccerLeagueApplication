package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Name.
 */
public class Name {
	
	/** The first name. */
	private String firstName;
	
	/** The middle name. */
	private String middleName;
	
	/** The last name. */
	private String lastName;
	
	/**
	 * Instantiates a new name.
	 *
	 * @param firstNameInput the first name input
	 * @param middleNameInput the middle name input
	 * @param lastNameInput the last name input
	 */
	public Name(String firstNameInput, String middleNameInput, String lastNameInput) {
		this.firstName =  firstNameInput;
		this.middleName = middleNameInput;
		this.lastName = lastNameInput;
	}
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Gets the middle name.
	 *
	 * @return the middle name
	 */
	public String getMiddleName() {
		return this.middleName;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return this.firstName + " " + this.middleName + " " + this.lastName;
	}
}
