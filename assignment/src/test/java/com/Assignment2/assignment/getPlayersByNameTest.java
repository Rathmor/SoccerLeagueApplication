package com.Assignment2.assignment;


import java.time.LocalDate;

import org.junit.Test;

import model.Manager;
import model.Model;
import model.Name;
import model.Team;

public class getPlayersByNameTest {

	@Test
	public void getPlayersByName() {
		Model model = new Model();
		Name name1 = new Name("Hubert", "B", "Cumberdale");
		LocalDate managerDOB = LocalDate.parse("2000-01-27");
		Manager manager = new Manager(name1, "0894437894", managerDOB);
		model.addTeam("Cool Team", "Blue and White", manager);
		
		Team teamEqual = new Team("Cool Team", "Blue and White");
		teamEqual.setManager(manager);
		
		model.addPlayer(model.getTeamByIndex(0), "Hubert H Humberdale", "0894345654", true, 4);
		model.addPlayer(model.getTeamByIndex(0), "Cubert C Cumberdale", "0894345654", true, 4);
		model.addPlayer(model.getTeamByIndex(0), "Aubert A Aumberdale", "0894345654", true, 4);
		model.addPlayer(model.getTeamByIndex(0), "Bubert B Bumberdale", "0894345654", true, 4);
		
		String text = model.getPlayersByName(teamEqual);
		System.out.println(text);
	}

}
