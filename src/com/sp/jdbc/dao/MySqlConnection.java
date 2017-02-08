package com.sp.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
	private static Connection CONNECTION;
	private static String URL = "jdbc:mysql://localhost/stockphone";
	private static String USERNAME = "root";
	private static String PASSWORD = "";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private MySqlConnection() {

	}

	public static Connection getConnection() {
		try {
			if (CONNECTION == null || CONNECTION.isClosed()) {
				CONNECTION = DriverManager.getConnection(URL, USERNAME,
						PASSWORD);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CONNECTION;
	}
}
