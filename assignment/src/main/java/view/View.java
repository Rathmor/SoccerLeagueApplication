package view;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Manager;
import model.Team;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.Controller;

public class View extends Application implements EventHandler<ActionEvent> {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	Controller controller = new Controller();
	@Override
	public void start(Stage primaryStage) {
		Image image = new Image("file:Resources\\output-onlinejpgtools.png", 120, 120, true, true);
		ImageView iv = new ImageView(image);
		
		// Creating labels
     	Label leagueIntroLine1 = new Label("The Big League");
     	Label leagueIntroLine2 = new Label("Enter Your Teams Into The League!");
     	leagueIntroLine1.setFont(new Font("Calibri", 35));
     	leagueIntroLine2.setFont(new Font("Calibri", 17));
    	Label teamName = new Label("Team Name:\t\t\t\t");
    	Label teamJersey = new Label("Team Jersey Colour:\t\t");
     	Label teamManager = new Label("Select Manager:\t\t\t");
     	Label teamSelect = new Label("Select Team:");
    	Label playerName = new Label("Player Name [first_middle_surname]:\t");
    	Label playerPhone = new Label("Player Phone Number:\t\t\t\t");
    	Label playerGoals = new Label("Number of Goals:\t\t\t\t\t");
    	Label playerRole = new Label("Check If Player Is Goalie:\t\t\t\t");
    	Label playerNameRemove = new Label("Player Name [first_middle_surname]:\t");
    	Label playerNameChange = new Label("Player Name to Update [first_middle_surname]:\t");
    	Label playerNameUpdate = new Label("Player Name [first_middle_surname]:\t");
    	Label playerPhoneUpdate = new Label("Player Phone Number:\t\t\t\t");
    	Label playerGoalsUpdate = new Label("  Number of Goals:\t\t\t\t\t");
    	Label playerRoleUpdate = new Label("Check If Player Is Goalie:\t\t\t\t");
    	Label playerTeamName = new Label("Select Team:");
    	Label managerName = new Label("Manager Name [first_middle_surname]:\t\t");
    	Label managerPhone = new Label("Manager Phone Number:\t\t\t\t");
    	Label managerDOB = new Label("Manager Date of Birth:\t\t\t\t\t");
    	Label managerRating = new Label("Manager Rating (0-10):\t\t\t\t      ");
    	Label managerNameRemove = new Label("Manager Name [first_middle_surname]:\t");
    	Label split1 = new Label("\t\t\t");
    	Label split2 = new Label("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ");
    	Label blank1 = new Label();
    	Label blank2 = new Label();
    	Label blank3 = new Label();
    	Label blank4 = new Label();
    	Label blank5 = new Label();
     	
    	// Creating checkboxes
     	final CheckBox goalie = new CheckBox();
     	final CheckBox goalieUpdate = new CheckBox();
     	
     	// Creating text boxes
    	final TextField teamNameField = new TextField();
    	final TextField teamJerseyField = new TextField();
    	final TextField managerNameField = new TextField();
    	final TextField managerNameRemoveField = new TextField();
    	final TextField managerPhoneField = new TextField();
    	final DatePicker managerDOBField = new DatePicker();
    	final TextField managerRatingField = new TextField();
    	final TextField playerNameField = new TextField();
    	final TextField playerPhoneField = new TextField();
    	final TextField playerGoalsField = new TextField();
    	final TextField playerNameRemoveField = new TextField();
    	final TextField playerNameChangeField = new TextField();
    	final TextField playerNameUpdateField = new TextField();
    	final TextField playerPhoneUpdateField = new TextField();
    	final TextField playerGoalsUpdateField = new TextField();
    	
    	// Creating Buttons
    	Button addTeamButton = new Button("Add Team");
    	Button addPlayerButton = new Button("Add Player");
    	Button addManagerButton = new Button("Add Manager");
    	Button removeTeamButton = new Button("Remove Team");
    	Button removePlayerButton = new Button("Remove Player");
    	Button removeManagerButton = new Button("Remove Manager");
    	Button updatePlayerButton = new Button("Update Player");
    	Button saveButton = new Button("save");
    	Button loadButton = new Button("Load from Database");
    	Button listPlayersButton = new Button("List Players ordered By Name");
    	Button listManagersByRatingButton = new Button("List Managers ordered By Rating");
    	Button listManagersByNameButton = new Button("List Managers ordered By Name");
    	Button listTeamsInLeagueButton = new Button("Display Teams in the League");
    	
    	// Creating a text area & setting padding
    	final TextArea textArea1 = new TextArea("Players to be Displayed");
    	final TextArea textArea2 = new TextArea("Managers to be Displayed");
    	
    	textArea1.setPadding(new Insets(10, 10, 10, 10));
    	textArea2.setPadding(new Insets(10, 10, 10, 10));
    	
    	// Creating a region to create spacing to separate exit button from load and save buttons in application
    	Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
    	Region region2 = new Region();
        HBox.setHgrow(region2, Priority.ALWAYS);
    	Region region3 = new Region();
        HBox.setHgrow(region3, Priority.ALWAYS);
    	Region region4 = new Region();
        HBox.setHgrow(region4, Priority.ALWAYS);
		
        // Creating combo boxes & setting padding
        final ComboBox<Team> teamsBoxLeague = new ComboBox<Team>();
        final ComboBox<Team> teamsBoxTeam = new ComboBox<Team>();
		final ComboBox<Team> teamsBoxPlayer = new ComboBox<Team>();
		final ComboBox<Manager> managersBox = new ComboBox<Manager>();
        
		teamsBoxLeague.setPadding(new Insets(10,10,10,10));
		
		// Creating Horizontal box layouts for the Vertical box layout and adding scene elements to them
		HBox loadButtonLine = new HBox(loadButton);
		HBox teamTeamLine = new HBox(teamSelect, teamsBoxTeam);
		HBox teamLine1 = new HBox(teamName, teamNameField, split1, removeTeamButton);
		HBox teamLine2 = new HBox(teamJersey, teamJerseyField);
		HBox teamLine3 = new HBox(teamManager, managersBox);
		HBox teamLine4 = new HBox(listPlayersButton, listTeamsInLeagueButton);
		HBox playerTeamLine = new HBox(playerTeamName, teamsBoxPlayer);
		HBox playerLine1 = new HBox(playerName, playerNameField, region1, playerNameChange, playerNameChangeField);
		HBox playerLine2 = new HBox(playerPhone, playerPhoneField, region2, playerNameUpdate, playerNameUpdateField);
		HBox playerLine3 = new HBox(playerGoals, playerGoalsField, region3, playerPhoneUpdate, playerPhoneUpdateField);
		HBox playerLine4 = new HBox(playerRole, goalie, region4, playerGoalsUpdate, playerGoalsUpdateField);
		HBox playerLine5 = new HBox(addPlayerButton, split2, playerRoleUpdate, goalieUpdate);
		HBox playerUpdateButtonLine = new HBox(updatePlayerButton);
		HBox playerLine6 = new HBox(playerNameRemove, playerNameRemoveField);
		HBox managerLine1 = new HBox(managerName, managerNameField);
		HBox managerLine2 = new HBox(managerPhone, managerPhoneField);
		HBox managerLine3 = new HBox(managerDOB, managerDOBField);
		HBox managerLine4 = new HBox(managerRating, managerRatingField);
		HBox managerLine5 = new HBox(managerNameRemove, managerNameRemoveField);
		HBox managerLine6 = new HBox(listManagersByRatingButton, listManagersByNameButton);
		
		// Creating empty hboxes to create artificial spacing
		HBox splitterLine1 = new HBox(blank1);
		HBox splitterLine2 = new HBox(blank2);
		HBox splitterLine3 = new HBox(blank3);
		HBox splitterLine4 = new HBox(blank4);
		HBox splitterLine5 = new HBox(blank5);

		// Accessory details for gui being added
		loadButtonLine.setAlignment(Pos.TOP_CENTER);
		teamLine4.setAlignment(Pos.CENTER);
		playerLine4.setSpacing(5);
		playerLine5.setSpacing(5);
		managerLine4.setSpacing(5);
		managerLine6.setAlignment(Pos.CENTER);
		playerUpdateButtonLine.setAlignment(Pos.BASELINE_RIGHT);
		
        // Creating a Vertical box layout
		VBox leagueTabLayout = new VBox();
		leagueTabLayout.setAlignment(Pos.CENTER);
		VBox teamTabLayout = new VBox();
		teamTabLayout.setPadding(new Insets(10,10,10,10));
		teamTabLayout.setSpacing(5);
		VBox playerTabLayout = new VBox();
		playerTabLayout.setPadding(new Insets(10,10,10,10));
		playerTabLayout.setSpacing(5);
		VBox managerTabLayout = new VBox();
		managerTabLayout.setPadding(new Insets(10,10,10,10));
		managerTabLayout.setSpacing(5);
		
		// Setting up layouts with elements
		leagueTabLayout.getChildren().addAll(loadButtonLine, leagueIntroLine1, leagueIntroLine2, iv, saveButton);
	    teamTabLayout.getChildren().addAll(teamTeamLine, splitterLine1, teamLine1, teamLine2, teamLine3, addTeamButton, splitterLine2, teamLine4, textArea1);
	    playerTabLayout.getChildren().addAll(playerTeamLine, splitterLine3, playerLine1, playerLine2, playerLine3, playerLine4, playerLine5, playerUpdateButtonLine, playerLine6, removePlayerButton);
	    managerTabLayout.getChildren().addAll(managerLine1, managerLine2, managerLine3, managerLine4, addManagerButton, splitterLine4, managerLine5, removeManagerButton, splitterLine5, managerLine6, textArea2);
		
	    // Creating tabpane and tabs for tabpane
        TabPane tabPane = new TabPane();
        Tab leagueTab = new Tab("Leagues");
        Tab teamTab = new Tab("Teams");
        Tab playerTab = new Tab("Players");
        Tab managerTab = new Tab("Managers");
        
        // setting contents of tabs with the layouts above
        leagueTab.setContent(leagueTabLayout);
        teamTab.setContent(teamTabLayout);
        playerTab.setContent(playerTabLayout);
        managerTab.setContent(managerTabLayout);
        
        leagueTab.setClosable(false);
        teamTab.setClosable(false);
        playerTab.setClosable(false);
        managerTab.setClosable(false);
        
        // adding tabs to tabpane
        tabPane.getTabs().add(leagueTab);
        tabPane.getTabs().add(teamTab);
        tabPane.getTabs().add(playerTab);
        tabPane.getTabs().add(managerTab);
        tabPane.setPadding(new Insets(5,5,5,5));

        // Creating vbox, scene, and setting the tabpane into the vbox as well as creating the scene window size. 
        VBox vBox = new VBox(tabPane);
        Scene scene = new Scene(vBox, Color.WHITE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Soccer League Application");
		primaryStage.setWidth(1000);
		primaryStage.setHeight(600);

        primaryStage.show();
        
        
        // Button clicks responding to being clicked and performing certain tasks.
    	addTeamButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent addButtonEvent) {
				controller.addTeam(teamNameField.getText(), teamJerseyField.getText(), managersBox.getValue());
				managersBox.getItems().remove(managersBox.getValue());
				teamsBoxPlayer.getItems().clear();
				teamsBoxLeague.getItems().clear();
				teamsBoxTeam.getItems().clear();
				int numberOfTeams = controller.getNumberOfTeams();
				for (int i=0; i<numberOfTeams; i++) {
					teamsBoxPlayer.getItems().add(controller.getTeamByIndex(i));
					teamsBoxLeague.getItems().add(controller.getTeamByIndex(i));
					teamsBoxTeam.getItems().add(controller.getTeamByIndex(i));		
				}
			}
    	});

    	addPlayerButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent addButtonEvent) {
				if (goalie.isSelected()) {
					controller.addPlayer(teamsBoxPlayer.getValue(), playerNameField.getText(), playerPhoneField.getText(), true, Integer.parseInt(playerGoalsField.getText()));
				} else {
					controller.addPlayer(teamsBoxPlayer.getValue(), playerNameField.getText(), playerPhoneField.getText(), false, Integer.parseInt(playerGoalsField.getText()));
				}
			}
    	});
    	
    	addManagerButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent addButtonEvent) {
				controller.addManager(managerNameField.getText(), managerPhoneField.getText(), managerDOBField.getValue(), Integer.parseInt(managerRatingField.getText()));
				managersBox.getItems().clear();
				ArrayList<Manager> managerList = controller.getManagerWithoutTeam();
				for (int i=0; i<managerList.size(); i++) {
					managersBox.getItems().add(managerList.get(i));
				}
			}
    	});
    	
    	removeTeamButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent addButtonEvent) {
				managersBox.getItems().add(teamsBoxTeam.getValue().getManager());
				controller.removeTeam(teamsBoxTeam.getValue());
				teamsBoxPlayer.getItems().clear();
				teamsBoxLeague.getItems().clear();
				teamsBoxTeam.getItems().clear();
				int numberOfTeams = controller.getNumberOfTeams();
				for (int i=0; i<numberOfTeams; i++) {
					teamsBoxPlayer.getItems().add(controller.getTeamByIndex(i));
					teamsBoxLeague.getItems().add(controller.getTeamByIndex(i));
					teamsBoxTeam.getItems().add(controller.getTeamByIndex(i));		
				}
			}
    	});
    	
    	removePlayerButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent addButtonEvent) {
				controller.removePlayer(teamsBoxPlayer.getValue(), playerNameRemoveField.getText());
			}
    	});
    	
    	removeManagerButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent addButtonEvent) {
				controller.removeManager(managerNameRemoveField.getText());
				managersBox.getItems().clear();
				ArrayList<Manager> managerList = controller.getManagerWithoutTeam();
				for (int i=0; i<managerList.size(); i++) {
					managersBox.getItems().add(managerList.get(i));
				}
			}
    	});
    	
    	
        updatePlayerButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent addButtonEvent) {
				if (goalieUpdate.isSelected()) {
					System.out.println(playerPhoneUpdateField.getText() + "Hello");
					controller.updatePlayer(teamsBoxPlayer.getValue(), playerNameChangeField.getText(), playerNameUpdateField.getText(), playerPhoneUpdateField.getText(), playerGoalsUpdateField.getText(), true);
				} else {
					controller.updatePlayer(teamsBoxPlayer.getValue(), playerNameChangeField.getText(), playerNameUpdateField.getText(), playerPhoneUpdateField.getText(), playerGoalsUpdateField.getText(), false);
				}
			}
    	});
        
    	listPlayersButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent addButtonEvent) {
				String text = controller.getPlayersByName(teamsBoxTeam.getValue());
				textArea1.setText(text);
			}
    	});

    	listTeamsInLeagueButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent addButtonEvent) {
				String text = controller.getTeamsInLeague();
				textArea1.setText(text);
			}
    	});
    	
    	listManagersByNameButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent addButtonEvent) {
				String text = controller.getManagersByName();
				textArea2.setText(text);
			}
    	});
    	
    	listManagersByRatingButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent addButtonEvent) {
				String text = controller.getManagersByRating();
				textArea2.setText(text);
			}
    	});
    	
    	loadButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent addButtonEvent) {
				try {
					teamsBoxPlayer.getItems().clear();
					teamsBoxLeague.getItems().clear();
					teamsBoxTeam.getItems().clear();
					managersBox.getItems().clear();
					ArrayList<Team> teamsList = controller.loadFromDB();
					for (int i=0; i<teamsList.size(); i++) {
						teamsBoxPlayer.getItems().add(teamsList.get(i));
						teamsBoxLeague.getItems().add(teamsList.get(i));
						teamsBoxTeam.getItems().add(teamsList.get(i));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
    	});
    	
    	saveButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent addButtonEvent) {
				try {
					controller.savetoDB();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
    	});
    	
	}
    public void handle(ActionEvent arg0) {
	}
}