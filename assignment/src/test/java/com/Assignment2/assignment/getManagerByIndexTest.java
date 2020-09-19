package com.Assignment2.assignment;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.Manager;
import model.Model;
import model.Name;

public class getManagerByIndexTest {

	@Test
	public void getManagerByIndex() {
		Model model = new Model();
		
		LocalDate managerDOB = LocalDate.parse("2000-01-27");
		model.addManager("Hubert H Humberdale", "0894345654", managerDOB, 4); // 0
		model.addManager("Cubert C Cumberdale", "0894345654", managerDOB, 4); // 1
		model.addManager("Aubert A Aumberdale", "0894345654", managerDOB, 4); // 2
		model.addManager("Bubert B Bumberdale", "0894345654", managerDOB, 4); // 3
		
		Name name1 = new Name("Aubert", "A", "Aumberdale");
		Manager managerAtIndex2 = new Manager(name1, "0894345654", managerDOB);
		managerAtIndex2.setRating(4);
		
		Manager manager = model.getManagerByIndex(2);
		assertTrue(manager.toString().equals(managerAtIndex2.toString()));
	}

}
