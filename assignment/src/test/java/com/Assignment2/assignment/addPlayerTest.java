package com.Assignment2.assignment;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.Manager;
import model.Model;
import model.Name;
import model.Player;

public class addPlayerTest {

	@Test
	public void addPlayer() {
		Model model = new Model();
		Name name1 = new Name("Hubert", "B", "Cumberdale");
		LocalDate managerDOB = LocalDate.parse("2000-01-27");
		Manager manager = new Manager(name1, "0894437894", managerDOB);
		model.addTeam("Cool Team", "Blue and White", manager);
		
		Name name2 = new Name("Hubert", "B", "Cumberdale");
		
		Player comparePlayer = new Player(name2, "0894345654", true);
		comparePlayer.setYearlyGoals(4);
		
		model.addPlayer(model.getTeamByIndex(0), "Hubert B Cumberdale", "0894345654", true, 4);
		assertTrue(model.getTeamByIndex(0).getPlayer(0).toString().equals(comparePlayer.toString()));	
	}
}