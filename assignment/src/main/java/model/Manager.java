package model;

import java.time.LocalDate;

// TODO: Auto-generated Javadoc
/**
 * The Class Manager.
 */
public class Manager extends Person {
	
	/** The date of birth. */
	private LocalDate dateOfBirth;
	
	/** The rating. */
	private int rating = 0;
	
	/** The team. */
	private Team team;
	
	/**
	 * Instantiates a new manager.
	 *
	 * @param nameInput the name input
	 * @param phoneInput the phone input
	 * @param dateOfBirthInput the date of birth input
	 */
	public Manager(Name nameInput, String phoneInput, LocalDate dateOfBirthInput) {
		super(nameInput, phoneInput);
		this.setDateOfBirth(dateOfBirthInput);
	}
	
	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public int getRating() {
		return this.rating;
	}
	
	/**
	 * Gets the team.
	 *
	 * @return the team
	 */
	public Team getTeam() {
		return this.team;
	}	
	
	/**
	 * Gets the date of birth.
	 *
	 * @return the date of birth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * Sets the rating.
	 *
	 * @param ratingInput the new rating
	 */
	public void setRating(int ratingInput) {
		this.rating = ratingInput;
	}
	
	/**
	 * Sets the team.
	 *
	 * @param team the new team
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
	
	/**
	 * Gets the manager.
	 *
	 * @return the manager
	 */
	public Manager getManager() {
		return this;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Manager Name:" + this.getName() + ", Phone:" + this.getPhone() + ", Email:" + this.getEmail() + ", Rating:" + this.rating;
	}

	/**
	 * Sets the date of birth.
	 *
	 * @param dateOfBirth the new date of birth
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
