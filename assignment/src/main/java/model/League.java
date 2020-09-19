package model;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class League.
 */
public class League {
	
	/** The team list. */
	private ArrayList<Team> teamList = new ArrayList<Team>();
	
	/**
	 * Adds the team.
	 *
	 * @param team the team
	 */
	public void addTeam(Team team) {
		this.teamList.add(team);
	}
	
	/**
	 * Removes the team.
	 *
	 * @param index the index
	 */
	public void removeTeam(int index) {
		this.teamList.remove(index);
	}
	
	/**
	 * Removes the team.
	 *
	 * @param teamName the team name
	 */
	public void removeTeam(String teamName) {
		for (int i = 0; i < this.teamList.size(); i++) {
			if (this.teamList.get(i).getName().equals(teamName)) {
				teamList.remove(i);
			}
		}
	}
	
	/**
	 * Gets the team by name.
	 *
	 * @param teamName the team name
	 * @return the team by name
	 */
	public Team getTeamByName(String teamName) {
		for (int i = 0; i < this.teamList.size(); i++) {
			if (this.teamList.get(i).getName().equals(teamName)) {
				return teamList.get(i);
			} else {
				continue;
			}
		}
		return null;
	}
	
	/**
	 * Gets the team.
	 *
	 * @param index the index
	 * @return the team
	 */
	public Team getTeam(int index) {
		return teamList.get(index);
	}
	
	/**
	 * Gets the teams.
	 *
	 * @return the teams
	 */
	public ArrayList<Team> getTeams() {
		return this.teamList;
	}
}

