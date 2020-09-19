package com.Assignment2.assignment;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.Manager;
import model.Model;
import model.Name;

public class removePlayerTest {

	@Test
	public void removePlayer() {
		Model model = new Model();
		Name name1 = new Name("Hubert", "B", "Cumberdale");
		LocalDate managerDOB = LocalDate.parse("2000-01-27");
		Manager manager = new Manager(name1, "0894437894", managerDOB);
		model.addTeam("Cool Team", "Blue and White", manager);
		
		model.addPlayer(model.getTeamByIndex(0), "Hubert B Cumberdale", "0894345654", true, 4);
		
		System.out.println("number of players in team: " + model.getTeamByIndex(0).getPlayers().size());
		
		model.getTeamByIndex(0).removePlayer(name1);
		assertEquals(model.getTeamByIndex(0).getPlayers().size(), 0);
		
		System.out.println("number of players in team: " + model.getTeamByIndex(0).getPlayers().size());
	}

}
