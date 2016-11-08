package com.innopolis.study.java2016.savelyev.lessons.lesson17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Simple Java program to connect to MySQL database running on localhost and
 * running SELECT and INSERT query to retrieve and add data.
 * @author Javin Paul
 */
public class SampleDB {

	// JDBC URL, username and password of MySQL server
	private static final String url = "jdbc:mysql://localhost:3306/lesson17";
	private static final String user = "root";
	private static final String password = "root";

	// JDBC variables for opening and managing connection
	private static Connection connection;
	private static Statement statement;
	private static ResultSet ResultSet;

	public static void main(String args[]) {
		String query = "select count(*) from users";

		try {
			// opening database connection to MySQL server
			connection = DriverManager.getConnection(url, user, password);

			// getting Statement object to execute query
			statement = connection.createStatement();

			// executing SELECT query
			ResultSet = statement.executeQuery(query);

			while (ResultSet.next()) {
				int count = ResultSet.getInt(1);
				System.out.println("Total number of users in the table : " + count);
			}

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			//close connection ,stmt and resultset here
			try {
				connection.close();
			} catch (SQLException se) { /*can't do anything */ }
			try {
				statement.close();
			} catch (SQLException se) { /*can't do anything */ }
			try {
				ResultSet.close();
			} catch (SQLException se) { /*can't do anything */ }
		}
	}
}