package com.Assignment2.assignment;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import model.Manager;
import model.Model;
import model.Name;

public class getManagerWithoutTeamTest {

	@Test
	public void test() {
		Model model = new Model();
		LocalDate managerDOB = LocalDate.parse("2000-01-27");
		
		model.addManager("Cubert C Cumberdale", "0894345654", managerDOB, 4);
		model.addManager("Hubert B Cumberdale", "0894437894", managerDOB, 4);
		Name name1 = new Name("Cubert", "C", "Cumberdale");
		Name name2 = new Name("Hubert", "B", "Cumberdale");
		
		Manager manager2 = new Manager(name2, "0894437894", managerDOB);
		manager2.setRating(4);
		model.addTeam("Team A", "blue", manager2);
		
		Manager managerWithoutTeam = new Manager(name1, "0894345654", managerDOB);
		managerWithoutTeam.setRating(4);
		
		ArrayList<Manager> managersWithoutTeam = model.getManagerWithoutTeam();
		
		assertEquals(managersWithoutTeam.size(), 1);
		assertTrue(managersWithoutTeam.get(0).toString().equals(managerWithoutTeam.toString()));
	}

}
