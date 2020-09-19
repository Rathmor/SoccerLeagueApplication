package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Person.
 */
public class Person {
	
	/** The name. */
	private Name name;
	
	/** The phone. */
	private String phone;
	
	/** The email. */
	private String email;
	
	/**
	 * Instantiates a new person.
	 *
	 * @param nameInput the name input
	 * @param phoneInput the phone input
	 */
	public Person(Name nameInput, String phoneInput) {
		this.name = nameInput;
		this.phone = phoneInput;
		this.email = this.name.getFirstName() + this.name.getMiddleName() + this.name.getLastName() + "@gmail.com";
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public Name getName() {
		return this.name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(Name name) {
		this.name = name;
		this.email = this.name.getFirstName() + this.name.getMiddleName() + this.name.getLastName() + "@gmail.com";
	}
	
	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Name:" + this.name + ", Phone:" + this.phone + ", Email:" + this.email;
	}
	
	/**
	 * Prints the.
	 */
	public void print() {
		System.out.println(toString());
	}
}
