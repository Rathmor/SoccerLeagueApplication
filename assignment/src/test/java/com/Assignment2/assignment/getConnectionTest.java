package com.Assignment2.assignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class getConnectionTest {
	@Test
	public void getConnection() throws SQLException {
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccer_league_db?useSSL=false&serverTimezone=UTC", "root", "1234");
	}
}