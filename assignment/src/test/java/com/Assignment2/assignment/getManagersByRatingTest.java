package com.Assignment2.assignment;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.Manager;
import model.Model;
import model.Name;

public class getManagersByRatingTest {

	@Test
	public void getManagersByRating() {
		Model model = new Model();
		
		LocalDate managerDOB = LocalDate.parse("2000-01-27");
		model.addManager("Hubert H Humberdale", "0894345654", managerDOB, 4); // 0
		model.addManager("Cubert C Cumberdale", "0894345654", managerDOB, 8); // 1
		model.addManager("Aubert A Aumberdale", "0894345654", managerDOB, 10); // 2
		model.addManager("Bubert B Bumberdale", "0894345654", managerDOB, 2); // 3
		
		String managersByRating = model.getManagersByRating();
		System.out.println(managersByRating);
	}

}
