package com.Assignment2.assignment;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.Manager;
import model.Model;
import model.Name;

public class addManagerTest {

	@Test
	public void addManager() {
		Model model = new Model();
		String managerName = "Hubert B Cumberdale";
		Name name = new Name("Hubert", "B", "Cumberdale");
		LocalDate managerDOB = LocalDate.parse("2000-01-27");
		int managerRating = 4;
		
		Manager managerCompare = new Manager(name, "0894457893", managerDOB);
		managerCompare.setRating(4);		
		model.addManager(managerName, "0894457893", managerDOB, managerRating);
		
		assertTrue(model.getManagerByIndex(0).toString().equals(managerCompare.toString()));
	}

}
