package com.Assignment2.assignment;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.Model;

public class removeManagerTest {

	@Test
	public void test() {
		Model model = new Model();
		LocalDate managerDOB = LocalDate.parse("2000-01-27");
		model.addManager("Hubert B Cumberdale", "0894437894", managerDOB, 5);
		
		System.out.println("number of managers: " + model.getNumberOfManagers());
		
		model.removeManager("Hubert B Cumberdale");
		assertEquals(model.getNumberOfManagers(), 0);
		
		System.out.println("number of managers: " + model.getNumberOfManagers());
	}

}
