package com.Assignment2.assignment;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.Manager;
import model.Model;
import model.Name;
import model.Team;

public class removeTeamTest {

	@Test
	public void removeTeam() {
		Model model = new Model();
		Name name1 = new Name("Hubert", "B", "Cumberdale");
		LocalDate managerDOB = LocalDate.parse("2000-01-27");
		Manager manager = new Manager(name1, "0894437894", managerDOB);
		model.addTeam("Cool Team", "Blue and White", manager);
		
		Team teamEqual = new Team("Cool Team", "Blue and White");
		teamEqual.setManager(manager);
		
		model.removeTeam(teamEqual);
		
		System.out.println(model.getNumberOfTeams());
		assertEquals(model.getNumberOfTeams(), 0);
	}

}
