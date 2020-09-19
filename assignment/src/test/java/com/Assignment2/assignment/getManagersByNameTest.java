package com.Assignment2.assignment;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.Manager;
import model.Model;
import model.Name;
import model.Team;

public class getManagersByNameTest {

	@Test
	public void getManagersByName() {
		Model model = new Model();
		Name name1 = new Name("Hubert", "B", "Cumberdale");
		LocalDate managerDOB = LocalDate.parse("2000-01-27");
		
		model.addManager("Hubert H Humberdale", "0894345654", managerDOB, 4);
		model.addManager("Cubert C Cumberdale", "0894345654", managerDOB, 4);
		model.addManager("Aubert A Aumberdale", "0894345654", managerDOB, 4);
		model.addManager("Bubert B Bumberdale", "0894345654", managerDOB, 4);
		
		String text = model.getManagersByName();
		System.out.println(text);
	}

}
