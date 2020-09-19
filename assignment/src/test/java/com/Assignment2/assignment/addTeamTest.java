package com.Assignment2.assignment;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.Manager;
import model.Model;
import model.Name;
import model.Team;

public class addTeamTest {

	@Test
	public void addTeam() {
		Model model = new Model();
		Name name1 = new Name("Hubert", "B", "Cumberdale");
		LocalDate managerDOB = LocalDate.parse("2000-01-27");
		Manager manager = new Manager(name1, "0894437894", managerDOB);
		
		Team teamCompare = new Team("Cool team", "blue and white");
		teamCompare.setManager(manager);
		
		model.addTeam("Cool team", "blue and white", manager);
		assertTrue(model.getTeamByIndex(0).toString().equals(teamCompare.toString()));
	}

}
