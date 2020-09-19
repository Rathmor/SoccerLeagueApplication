package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class Model.
 */
public class Model {
	
	/** The league. */
	League league = new League();
	
	/** The manager list. */
	ArrayList<Manager> managerList = new ArrayList<Manager>();
	
	/**
	 * Adds a manager to the list of managers.
	 *
	 * @param name. Manager name
	 * @param phone. Manager phone
	 * @param dob. Manager date of birth
	 * @param rating. Manager rating
	 */
	public void addManager(String name, String phone, LocalDate dob, int rating) {
		String[] managerNameSplit = name.split(" ");
		Name managerName = new Name(managerNameSplit[0], managerNameSplit[1], managerNameSplit[2]);
		Manager manager = new Manager(managerName, phone, dob);
		manager.setRating(rating);
		managerList.add(manager);
	}
	
	/**
	 * Adds a manager to the list of managers from the database
	 *
	 * @param name. Manager name
	 * @param phone. Manager phone
	 * @param dob. Manager date of birth
	 * @param rating. Manager rating
	 * @param teamName. Name of team Managers is managing
	 */
	public void addManagerFromDB(String name, String phone, LocalDate dob, int rating, String teamName) {
		String[] managerNameSplit = name.split(" ");
		Name managerName = new Name(managerNameSplit[0], managerNameSplit[1], managerNameSplit[2]);
		Manager manager = new Manager(managerName, phone, dob);
		manager.setRating(rating);
		managerList.add(manager);
	}
	
	/**
	 * Adds a player to a specified team.
	 *
	 * @param team. Team the player is being added to
	 * @param name. Player name
	 * @param phone. Player phone
	 * @param goalie. Is the player a goalie
	 * @param goals. Players yearly goals
	 */
	public void addPlayer(Team team, String name, String phone, boolean goalie, int goals) {
		String[] playerNameSplit = name.split(" ");
		Name playerName = new Name(playerNameSplit[0], playerNameSplit[1], playerNameSplit[2]);
		Player player = new Player(playerName, phone, goalie);
		player.setYearlyGoals(goals);
	    for (int i=0; i<league.getTeams().size(); i++) {
	    	if (league.getTeam(i).toString().equals(team.toString())) {
	    		league.getTeam(i).addPlayer(player);
	    	}
	    }
	}
	
	/**
	 * Adds a player from a database to a specified team named after the 'teamName' variable
	 *
	 * @param teamName. Name of team the player is being added to
	 * @param name. Player name
	 * @param phone. Player phone
	 * @param goalie. Is the player a goalie
	 * @param goals. Players yearly goals
	 */
	public void addPlayerFromDB(String teamName, String name, String phone, boolean goalie, int goals) {
		String[] playerNameSplit = name.split(" ");
		Name playerName = new Name(playerNameSplit[0], playerNameSplit[1], playerNameSplit[2]);
		Player player = new Player(playerName, phone, goalie);
		player.setYearlyGoals(goals);
	    for (int i=0; i<league.getTeams().size(); i++) {
	    	if (league.getTeam(i).getName().toString().equals(teamName)) {
	    		league.getTeam(i).addPlayer(player);
	    	}
	    }
	}
	
	/**
	 * Updates an existing players attributes.
	 *
	 * @param team. Team the player belongs to
	 * @param originalName the original name of Player
	 * @param name. Player name
	 * @param phone. Player phone
	 * @param goalie. Is the player a goalie
	 * @param goals. Players yearly goals
	 */
	public void updatePlayer(Team team, String originalName, String name, String phone, String goals, boolean goalie) {
		String[] playerNameSplit = originalName.split(" ");
		String playerName = playerNameSplit[0] + " " + playerNameSplit[1] + " " + playerNameSplit[2];
	    for (int i=0; i<league.getTeams().size(); i++) {
	    	if (league.getTeam(i).toString().equals(team.toString())) {
	    		for (int o=0; o<league.getTeam(i).getPlayers().size(); o++) {
	    			if (league.getTeam(i).getPlayer(o).getName().toString().equals(playerName)) {
	    				if (!name.isEmpty()) {
	    					String[] newPlayerNameSplit = name.split(" ");
	    					Name newPlayerName = new Name(newPlayerNameSplit[0], newPlayerNameSplit[1], newPlayerNameSplit[2]);
	    					league.getTeam(i).getPlayer(o).setName(newPlayerName);
	    				}
	    				if (!phone.isEmpty()) {
	    					league.getTeam(i).getPlayer(o).setPhone(phone);
	    				}
	    				if (!goals.isEmpty()) {
	    					league.getTeam(i).getPlayer(o).setYearlyGoals(Integer.parseInt(goals));
	    				}
	    				league.getTeam(i).getPlayer(o).setGoalie(goalie);
	    				break;
	    			}
	    		}
	    	}
	    }
	}
	
	/**
	 * Adds a team to the league.
	 *
	 * @param name. Team name
	 * @param jersey. Team jersey colour
	 * @param manager. Team manager
	 */
	public void addTeam(String name, String jersey, Manager manager) {
		Team team = new Team(name, jersey);
		team.setManager(manager);
		for (int i=0; i<managerList.size(); i++) {
			if (managerList.get(i).toString().equals(manager.toString())) {
				managerList.get(i).setTeam(team);
			}
		}
		league.addTeam(team);
	}
	
	/**
	 * Adds a team from the database to the league.
	 *
	 * @param name. Team name
	 * @param jersey. Team jersey colour
	 * @param managerName. The name of the Manager
	 */
	public void addTeamFromDB(String name, String jersey, String managerName) {
		Team team = new Team(name, jersey);
		for (int i=0; i<managerList.size(); i++) {
			if (managerList.get(i).getName().toString().equals(managerName)) {
				team.setManager(managerList.get(i));
				managerList.get(i).setTeam(team);
			}
		}
		league.addTeam(team);
	}
	
	/**
	 * Removes a team from the league
	 *
	 * @param team. Team name
	 */
	public void removeTeam(Team team) {
	    for (int i=0; i<league.getTeams().size(); i++) {
	    	if (league.getTeam(i).toString().equals(team.toString())) {
	    		league.removeTeam(i);
	    		break;
	    	}
	    }
	}
	
	/**
	 * Removes a Player from an existing team in the league
	 *
	 * @param team. Team the player belongs to
	 * @param name. Player name
	 */
	public void removePlayer(Team team, String name) {
		String[] playerNameSplit = name.split(" ");
		Name playerName = new Name(playerNameSplit[0], playerNameSplit[1], playerNameSplit[2]);
	    for (int i=0; i<league.getTeams().size(); i++) {
	    	if (league.getTeam(i).toString().equals(team.toString())) {
	    		league.getTeam(i).removePlayer(playerName);
	    		break;
	    	}
	    }
	}
	
	/**
	 * Removes a manager from the list of managers
	 *
	 * @param name. Manager name
	 */
	public void removeManager(String name) {
		String[] managerNameSplit = name.split(" ");
		String managerName = managerNameSplit[0] + " " + managerNameSplit[1] + " " + managerNameSplit[2];
	    for (int i=0; i<managerList.size(); i++) {
	    	if (managerList.get(i).getName().toString().equals(managerName)) {
	    		managerList.remove(i);
	    		break;
	    	}
	    }
	}
	
	/**
	 * Gets all players of a specified team in a string sorted by name
	 *
	 * @param team. Team the players belong to
	 * @return String containing players of specified team sorted by name
	 */
	public String getPlayersByName(Team team) {
		String text = "";
	    for (int i=0; i<league.getTeams().size(); i++) {
	    	if (league.getTeam(i).toString().equals(team.toString())) {
	    		Collections.sort(league.getTeam(i).getPlayers(), new Comparator<Player>() {
	    			public int compare(Player o1, Player o2) {
	    				return  o1.getName().toString().toLowerCase().compareTo(o2.getName().toString().toLowerCase());
	    			}
	    		});
	    		
	    		for (int o=0; o<league.getTeam(i).getPlayers().size(); o++) {
	    			text += league.getTeam(i).getPlayer(o) + "\n";
	    		}
	    		return text;
	    	}
	    }
	    return text;
	}
	
	/**
	 * Gets all managers from the list of managers in a string sorted by name
	 *
	 * @return String containing managers sorted by name
	 */
	public String getManagersByName() {
		String text = "";
		Collections.sort(managerList, new Comparator<Manager>() {
			public int compare(Manager o1, Manager o2) {
				return  o1.getName().toString().toLowerCase().compareTo(o2.getName().toString().toLowerCase());
			}
		});
		
		for (int i=0; i<managerList.size(); i++) {
			text += managerList.get(i) + "\n";
		}
		return text;
	}
	
	/**
	 * Gets all managers from the list of managers in a string sorted by their rating
	 *
	 * @return String containing managers sorted by rating
	 */
	public String getManagersByRating() {
		String text = "";
		Collections.sort(managerList, new Comparator<Manager>() {
			public int compare(Manager o1, Manager o2) {
				return  o2.getRating() - o1.getRating();
			}
		});
		
		for (int i=0; i<managerList.size(); i++) {
			text += managerList.get(i) + "\n";
		}
		return text;
	}
	
	/**
	 * Gets the number of managers in list of managers.
	 *
	 * @return The number of existing managers
	 */
	public int getNumberOfManagers() {
		return managerList.size();
	}
	
	/**
	 * Gets the number of teams in the league.
	 *
	 * @return the number of existing teams in the league
	 */
	public int getNumberOfTeams() {
		return league.getTeams().size();
	}
	
	/**
	 * Gets all the managers from the manager list who do not have a team they are managing.
	 *
	 * @return ArrayList of Managers not currently managing a team
	 */
	public ArrayList<Manager> getManagerWithoutTeam() {
		ArrayList<Manager> managerListWithTeam = new ArrayList<Manager>();
		for (int i=0; i<managerList.size(); i++) {
			if (managerList.get(i).getTeam() == null) {
				managerListWithTeam.add(managerList.get(i));
			}
		}
		return managerListWithTeam;
	}
	
	/**
	 * Gets the manager by index from the list of managers
	 *
	 * @param index. The index of desired manager in the list of managers
	 * @return Manager at specified index from list of managers
	 */
	public Manager getManagerByIndex(int index) {
		return managerList.get(index);
	}
	
	/**
	 * Gets the team by index from the list of teams in the league
	 *
	 * @param index. The index of desired team in the list of teams in the league
	 * @return Team at specified index from the list of teams in the league
	 */
	public Team getTeamByIndex(int index) {
		return league.getTeam(index);
	}
	
	/**
	 * Gets the team from the list of teams in the league with the specified name and jersey colour.
	 *
	 * @param name. Team name
	 * @param jersey. Jersey colour
	 * @return Team with the specified name and jersey colour
	 */
	public Team getTeam(String name, String jersey) {
		Team team = new Team(name, jersey);
	    for (int i=0; i<league.getTeams().size(); i++) {
	    	if (league.getTeam(i).equals(team)) {
	    		return league.getTeam(i);
	    	}
	    }
	    return null;
	}
	
	/**
	 * Gets the teams from the list of teams in the league.
	 *
	 * @return ArrayList of Teams that are currently in the league
	 */
	public ArrayList<Team> getTeams() {
		return league.getTeams();
	}
	
	/**
	 * Gets the teams from the list of teams in the league as a string.
	 *
	 * @return String containing all the existing teams in the league
	 */
	public String getTeamsInLeague() {
		String text = "";
		for (int i=0; i<league.getTeams().size(); i++) {
			text += league.getTeam(i) + "\n";
		}
		return text;
	}
}
