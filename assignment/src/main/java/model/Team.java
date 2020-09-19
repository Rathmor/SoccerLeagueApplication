package model;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Team.
 */
public class Team {
	
	/** The team name. */
	private String teamName;
	
	/** The jersey colour. */
	private String jerseyColour;
	
	/** The manager. */
	private Manager manager;
	
	/** The team players. */
	private ArrayList<Player> teamPlayers = new ArrayList<Player>();
	
	/**
	 * Instantiates a new team.
	 *
	 * @param teamNameInput the team name input
	 * @param jerseyColourInput the jersey colour input
	 */
	public Team(String teamNameInput, String jerseyColourInput) {
		this.teamName = teamNameInput;
		this.jerseyColour = jerseyColourInput;
	}	
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.teamName;
	}
	
	/**
	 * Gets the jersey.
	 *
	 * @return the jersey
	 */
	public String getJersey() {
		return this.jerseyColour;
	}
	
	/**
	 * Sets the manager.
	 *
	 * @param managerInput the new manager
	 */
	public void setManager(Manager managerInput) {
		this.manager = managerInput;
	}
	
	/**
	 * Gets the manager.
	 *
	 * @return the manager
	 */
	public Manager getManager() {
		return this.manager;
	}
	
	/**
	 * Adds the player.
	 *
	 * @param playerInput the player input
	 */
	public void addPlayer(Player playerInput) {
		this.teamPlayers.add(playerInput);
	}
	
	/**
	 * Removes the player.
	 *
	 * @param name the name
	 */
	public void removePlayer(Name name) {
		for (int i = 0; i < this.teamPlayers.size(); i++) {
			if (this.teamPlayers.get(i).getName().toString().equals(name.toString())) {
				this.teamPlayers.remove(i);
				break;
			} 
		}
	}
	
	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return this.teamPlayers;
	}
	
	/**
	 * Gets the player.
	 *
	 * @param playerNameInput the player name input
	 * @return the player
	 */
	public Player getPlayer(Name playerNameInput) {
		for (int i = 0; i < this.teamPlayers.size(); i++) {
			if (this.teamPlayers.get(i).getName().toString().equals(playerNameInput.toString())) {
				return this.teamPlayers.get(i);
			} else {
				continue;
			}
		}
		return null;
	}
	
	/**
	 * Gets the player.
	 *
	 * @param index the index
	 * @return the player
	 */
	public Player getPlayer(int index) {
		return teamPlayers.get(index);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Team Name:" + this.teamName + ", Team Manager:" + this.manager.getName() + ", Team Jersey:" + this.jerseyColour;
	}
}
