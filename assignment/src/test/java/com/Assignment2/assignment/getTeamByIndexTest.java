package com.Assignment2.assignment;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.Manager;
import model.Model;
import model.Name;
import model.Team;

public class getTeamByIndexTest {

	@Test
	public void getTeamByIndex() {
		Model model = new Model();
		Name name1 = new Name("Hubert", "H", "Humberdale");
		Name name2 = new Name("Cubert", "C", "Cumberdale");
		Name name3 = new Name("Bubert", "B", "Bumberdale");
		LocalDate managerDOB = LocalDate.parse("2000-01-27");
		Manager manager1 = new Manager(name1, "0894437894", managerDOB);
		Manager manager2 = new Manager(name2, "0894433494", managerDOB);
		Manager manager3 = new Manager(name2, "0892317894", managerDOB);
		
		model.addTeam("Cool team A", "Blue", manager1);  // 0
		model.addTeam("Cool team B", "Red", manager2);   // 1
		model.addTeam("Cool team C", "Green", manager3); // 2
		
		Team teamAtIndex1 = new Team("Cool team B", "Red");
		teamAtIndex1.setManager(manager2);
		
		assertTrue(model.getTeamByIndex(1).toString().equals(teamAtIndex1.toString()));
	}

}
