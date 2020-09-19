package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller {
	
	/** The model object used by the controller class to communicate with the model and relay information back to the view. */
	Model model = new Model();
	
    /**
     * Gets the connection to the soccer_league_db database in MySQL
     *
     * @return the connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/soccer_league_db?useSSL=false&serverTimezone=UTC", "root", "1234");
    }
	
	/**
	 * Calls the addManager() method in model class to add a new manager.
	 *
	 * @param name. Manager name
	 * @param phone. Manager phone
	 * @param dob. Manager date of birth
	 * @param rating. Manager rating
	 */
	public void addManager(String name, String phone, LocalDate dob, int rating) {
		model.addManager(name, phone, dob, rating);
	}
	
	/**
	 * Calls the addPlayer() method in model class to Add the player to a team.
	 *
	 * @param team. Team the player is being added to
	 * @param name. Player name
	 * @param phone. Player phone
	 * @param goalie. Is the player a goalie
	 * @param goals. Players yearly goals
	 */
	public void addPlayer(Team team, String name, String phone, boolean goalie, int goals) {
		model.addPlayer(team, name, phone, goalie, goals);
	}
	
	/**
	 * Calls the updatePlayer() method in model class to update an existing players attributes
	 *
	 * @param team. Team the player is being added to
	 * @param originalName. The actual Player name
	 * @param name. Player name
	 * @param phone. Player phone
	 * @param goals. Players yearly goals
	 * @param goalie. Is the player a goalie
	 */
	public void updatePlayer(Team team, String originalName, String name, String phone, String goals, boolean goalie) {
		model.updatePlayer(team, originalName, name, phone, goals, goalie);
	}
	
	/**
	 * Calls the addTeam() method in model class to add a new team to the league
	 *
	 * @param name. Team name
	 * @param jersey. Team jersey colour
	 * @param manager. Team manager
	 */
	public void addTeam(String name, String jersey, Manager manager) {
		model.addTeam(name, jersey, manager);
	}
	
	/**
	 * calls the removeTeam() method in model class to remove an existing team from the league.
	 *
	 * @param team. Team name
	 */
	public void removeTeam(Team team) {
		model.removeTeam(team);
	}
	
	/**
	 * calls the removePlayer() method in model class to remove an existing player from an existing team
	 *
	 * @param team. Team name
	 * @param name. Player name
	 */
	public void removePlayer(Team team, String name) {
		model.removePlayer(team, name);
	}
	
	/**
	 * calls the removeManager() method in model class to remove an existing manager not currently managing a team.
	 *
	 * @param name. Manager name
	 */
	public void removeManager(String name) {
		model.removeManager(name);
	}
	
    /**
     * calls the getPlayersByName() method in model class and stores output in String variable 'text' and returns this String
     *
     * @param team. Team name
     * @return A string displaying players ordered by name
     */
    public String getPlayersByName(Team team) {
    	String text = model.getPlayersByName(team);
		return text;
    }
	
    /**
     * calls the getManagersByName() method in model class and stores output in String variable 'text' and returns this String 
     *
     * @return A string displaying players ordered by name
     */
    public String getManagersByName() {
    	String text = model.getManagersByName();
    	return text;
    }
    
    /**
     *  calls the getManagerByIndex() method in model class and returns an existing manager at provided index
     *
     * @param index. The index of desired manager in ArrayList
     * @return Manager object at specified index
     */
    public Manager getManagerByIndex(int index) {
    	return model.getManagerByIndex(index);
    }
    
    /**
     *  calls the getManagerWithoutTeam() method in model class and returns an ArrayList of Managers that are without a team
     *
     * @return ArrayList of Managers without team
     */
    public ArrayList<Manager> getManagerWithoutTeam() {
    	return model.getManagerWithoutTeam();
    }
    
    /**
     *  calls the getTeamByIndex() method in model class and returns an existing team at provided index
     *
     * @param index. The index of desired team in ArrayList
     * @return Team object at specified index
     */
    public Team getTeamByIndex(int index) {
    	return model.getTeamByIndex(index);
    }
    
    /**
     * calls the getNumberOfManager() method in model class and returns number of currently existing managers
     *
     * @return Number of managers
     */
    public int getNumberOfManagers() {
    	return model.getNumberOfManagers();
    }
    
    /**
     * calls the getNumberOfTeams() method in model class and returns number of currently existing teams
     *
     * @return Number of teams
     */
    public int getNumberOfTeams() {
    	return model.getNumberOfTeams();
    }
    
    /**
     * calls the getTeamsInLeague() method in model class and returns all team objects currently in the league as a String
     *
     * @return String displaying all teams in the league
     */
    public String getTeamsInLeague() {
    	return model.getTeamsInLeague();
    }
    
    /**
     * calls the getManagersByRating() method in model class and stores output in String variable 'text' containing all managers ordered by Rating
     *
     * @return String displaying all managers sorted by rating
     */
    public String getManagersByRating() {
    	String text = model.getManagersByRating();
    	return text;
    }
    
	/**
	 * Saves all existing teams and their corresponding players and manager into a database.
	 *
	 * @throws SQLException
	 */
	public void savetoDB() throws SQLException {
		ArrayList<Team> listOfTeams = model.getTeams();
		Statement myStmt = getConnection().createStatement();
		for (int i=0; i<listOfTeams.size(); i++) {
			myStmt.executeUpdate("Delete from manager where team_name = '" + listOfTeams.get(i).getName() + "'");
			myStmt.executeUpdate("Delete from player where team_name = '" + listOfTeams.get(i).getName() + "'");
			myStmt.executeUpdate("Delete from team where team_name = '" + listOfTeams.get(i).getName() + "'");
			String teamQuery = "Insert into team " + " (team_name, jersey_colour, manager_name)" + " values('"
					+ listOfTeams.get(i).getName() + "', '" + listOfTeams.get(i).getJersey() + "', '" + listOfTeams.get(i).getManager().getName() + "')";
			String managerQuery = "Insert into manager "
					+ " (manager_name, phone_number, manager_email, date_of_birth, rating, team_name)" + " values('"
					+ listOfTeams.get(i).getManager().getName() + "', '" + listOfTeams.get(i).getManager().getPhone() + "', '"
					+ listOfTeams.get(i).getManager().getEmail() + "', '" + listOfTeams.get(i).getManager().getDateOfBirth() + "', "
					+ listOfTeams.get(i).getManager().getRating() + ", '" + listOfTeams.get(i).getName() + "')";
			String playerQuery = "";

			myStmt.executeUpdate(teamQuery);
			myStmt.executeUpdate(managerQuery);
			for (int o = 0; o < listOfTeams.get(i).getPlayers().size(); o++) {
				playerQuery = "Insert into player "
						+ " (player_name, phone_number, player_email, yearly_goals, goalie, team_name)" + " values('"
						+ listOfTeams.get(i).getPlayer(o).getName() + "', '" + listOfTeams.get(i).getPlayer(o).getPhone() + "', '"
						+ listOfTeams.get(i).getPlayer(o).getEmail() + "', " + listOfTeams.get(i).getPlayer(o).getYearlyGoals() + ", "
						+ listOfTeams.get(i).getPlayer(o).getGoalie() + ", '" + listOfTeams.get(i).getName() + "')";
				myStmt.executeUpdate(playerQuery);
			}
		}
		System.out.println("Insert Successful!");
	}
	
	/**
	 * Loads all teams and their corresponding players and manager from the database and calls getTeams() method in model class to return an ArrayList of Teams to store in view
	 *
	 * @return ArrayList containing all teams loaded from database
	 * @throws SQLException
	 */
	public ArrayList<Team> loadFromDB() throws SQLException {
		Statement myStmt = getConnection().createStatement();
		ResultSet managerSet  = myStmt.executeQuery("select * from manager");
		while (managerSet.next()) {
			String name = managerSet.getString(1);
			String phone = managerSet.getString(2);
		    LocalDate dateOfBirth = LocalDate.parse(managerSet.getString(4));
		    int rating = managerSet.getInt(5);
		    String teamName = managerSet.getString(6);
		    model.addManagerFromDB(name, phone, dateOfBirth, rating, teamName);
		}
		ResultSet teamSet  = myStmt.executeQuery("select * from team");
		while (teamSet.next()) {
			String name = teamSet.getString(1);
			String jersey = teamSet.getString(2);
			String managerName = teamSet.getString(3);
		    model.addTeamFromDB(name, jersey, managerName);;
		}		
		ResultSet playerSet  = myStmt.executeQuery("select * from player");
		while (playerSet.next()) {
			String name = playerSet.getString(1);
			String phone = playerSet.getString(2);
		    int yearlyGoals = playerSet.getInt(4);
		    boolean goalie = playerSet.getBoolean(5);
		    String teamName = playerSet.getString(6);
		    model.addPlayerFromDB(teamName, name, phone, goalie, yearlyGoals);
		}
		return model.getTeams();
	}
}