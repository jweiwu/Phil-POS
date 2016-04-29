package com.phil.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	private static String url = "jdbc:mysql://140.125.84.71:3306/phil?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8";
	private static String user = "phil";
	private static String pass = "1qaz2wsx";
	private Connection conn = null;

	public DBconnection() throws Exception {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver found");

			try {
				conn = DriverManager.getConnection(url, user, pass);
				System.out.println("Connect database successfully");

			} catch (SQLException e) {

				System.out.println("Someting went wrong in the connection string");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found" + e);
		}

	}

	public Connection getConnection() {
		return conn;
	}

	public void close() throws Exception {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
