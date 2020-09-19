package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player extends Person {
	
	/** The yearly goals. */
	private int yearlyGoals = 0;
	
	/** The is goalie. */
	private boolean isGoalie;

	/**
	 * Instantiates a new player.
	 *
	 * @param nameInput the name input
	 * @param phoneInput the phone input
	 * @param isGoalieInput the is goalie input
	 */
	public Player(Name nameInput, String phoneInput, boolean isGoalieInput) {
		super(nameInput, phoneInput);
		this.isGoalie = isGoalieInput;
	}
	
	/**
	 * Sets the goalie.
	 *
	 * @param goalie the new goalie
	 */
	public void setGoalie(boolean goalie) {
		this.isGoalie = goalie;
	}
	
	/**
	 * Gets the goalie.
	 *
	 * @return the goalie
	 */
	public boolean getGoalie() {
		return this.isGoalie;
	}
	
	/**
	 * Sets the yearly goals.
	 *
	 * @param yearlyGoalsInput the new yearly goals
	 */
	public void setYearlyGoals(int yearlyGoalsInput) {
		this.yearlyGoals = yearlyGoalsInput;
	}
	
	/**
	 * Gets the yearly goals.
	 *
	 * @return the yearly goals
	 */
	public int getYearlyGoals() {
		return this.yearlyGoals;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		if (this.isGoalie == true) {
			return "Player Name:" + this.getName() + ", Phone:" + this.getPhone() + ", Email:" + this.getEmail() + ", Goalie:" + this.isGoalie + ", GoalsPerYear(while defending):" + this.yearlyGoals;
		} else if (this.isGoalie == false) {
			return "Player Name:" + this.getName() + ", Phone:" + this.getPhone() + ", Email:" + this.getEmail() + ", Goalie:" + this.isGoalie + ", GoalsPerYear:" + this.yearlyGoals;
		}
		return null;
	}
}
