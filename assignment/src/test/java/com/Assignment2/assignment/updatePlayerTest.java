package com.Assignment2.assignment;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.Manager;
import model.Model;
import model.Name;
import model.Player;

public class updatePlayerTest {

	@Test
	public void updatePlayer() {
		Model model = new Model();
		Name name1 = new Name("Hubert", "B", "Cumberdale");
		LocalDate managerDOB = LocalDate.parse("2000-01-27");
		Manager manager = new Manager(name1, "0894437894", managerDOB);
		model.addTeam("Cool Team", "Blue and White", manager);
		
		
		Name newName = new Name("Bubert", "B", "Bumberdale");
		Player comparePlayer = new Player(newName, "0111111111", false);
		comparePlayer.setYearlyGoals(100);
		
		model.addPlayer(model.getTeamByIndex(0), "Hubert B Cumberdale", "0894345654", true, 4);
		
		model.updatePlayer(model.getTeamByIndex(0), "Hubert B Cumberdale", "Bubert B Bumberdale", "0111111111", "100", false);
		assertTrue(model.getTeamByIndex(0).getPlayer(0).toString().equals(comparePlayer.toString()));
	}

}
