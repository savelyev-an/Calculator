package com.innopolis.study.java2016.savelyev.lessons.lesson17;

import java.sql.*;

/**
 * Created by User on 26.10.2016.
 */
public class SampleDB2 {

	// JDBC URL, username and password of MySQL server
	private static final String url = "jdbc:mysql://localhost:3306/lesson17";
	private static final String user = "root";
	private static final String password = "root";

	// JDBC variables for opening and managing connection

	public static void main(String args[]) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			) {

			String query = "select * from users";
			try (ResultSet	resultSet = statement.executeQuery(query);) {
				while (resultSet.next()) {
					System.out.println(resultSet.getString(2) + " " + resultSet.getString("lastName"));
				}
			}
			clearJournal(statement);
			fillJournal (statement);
			fillJournalWithPreapredQuery(connection);
			getReport1(statement);
			getReport2(statement);
			String name="Alex";
			String lastName ="Savelyev";
			getDataForStudent(statement, name, lastName);

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
	}

	private static void fillJournalWithPreapredQuery(Connection connection) throws SQLException {
		String preparedQuery = "INSERT INTO `lesson17`.`journal` (`id_user`, `id_lesson`) VALUES (?,?);";

		PreparedStatement preparedStatment = connection.prepareStatement(preparedQuery);
		preparedStatment.setInt(1,2);
		preparedStatment.setInt(2,1);
		preparedStatment.executeUpdate();

		preparedStatment.setInt(1,2);
		preparedStatment.setInt(2,3);
		preparedStatment.executeUpdate();

	}

	private static void getDataForStudent(Statement statement, String name, String lastName) throws SQLException {
		System.out.println("Поиск по базе для студента "+lastName +" "+name);
		String query = "SELECT lessons.topic, lessons.date \n" +
				"    FROM users \n" +
				"    JOIN journal ON users.id=journal.id_user \n" +
				"    JOIN lessons ON journal.id_lesson=lessons.id \t\n" +
				"    WHERE users.name='"+name+"' AND users.lastName='"+lastName+"' \n" +
				"    ORDER BY lessons.date";
		try (ResultSet	resultSet = statement.executeQuery(query);) {
			while (resultSet.next()) {
				StringBuilder stringBuilder = new StringBuilder();
				for ( int i=1 ; i<=2 ;i++)
					stringBuilder=stringBuilder.append(resultSet.getString (i)).append(' ');
				System.out.println(stringBuilder);
			}
		}



	}

	private static void getReport1(Statement statement) throws SQLException {
		System.out.println("Список занятий и студентов, посетивших их");
		String query = "SELECT lessons.topic, lessons.date, users.name, users.lastName " +
				"FROM lessons JOIN journal ON lessons.id=journal.id_lesson JOIN users ON journal.id_user=users.id " +
				"ORDER BY lessons.date, lessons.topic;";
		try (ResultSet	resultSet = statement.executeQuery(query);) {
			while (resultSet.next()) {
				StringBuilder stringBuilder = new StringBuilder();
				for ( int i=1 ; i<=4 ;i++)
					stringBuilder=stringBuilder.append(resultSet.getString (i)).append(' ');
				System.out.println(stringBuilder);
			}
		}
	}

	private static void getReport2(Statement statement) throws SQLException {
		System.out.println("Список студентов не посетивших ничего");

		String query = "SELECT  users.lastName, users.name  FROM users " +
				"WHERE users.id NOT IN (SELECT DISTINCT id_user FROM journal)";
		try (ResultSet	resultSet = statement.executeQuery(query);) {
			while (resultSet.next()) {
				StringBuilder stringBuilder = new StringBuilder();
				for ( int i=1 ; i<=2 ;i++)
					stringBuilder=stringBuilder.append(resultSet.getString (i)).append(' ');
				System.out.println(stringBuilder);
			}
		}
	}

	private static void fillJournal(Statement statement) throws SQLException {
		String query = "INSERT INTO `lesson17`.`journal` (`id_user`, `id_lesson`) VALUES (1,1),(1,2),(1,3);";
		int ignored = statement.executeUpdate(query);
	}

	private static void clearJournal(Statement statement) throws SQLException {
		String query = "DELETE FROM `lesson17`.`journal`";
		int ignored = statement.executeUpdate(query);
	}


}
