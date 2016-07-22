package com.phil.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	private static String url = "jdbc:mysql://localhost:3306/phil?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static String user = "jwei";
	private static String pass = "dir/+5397";
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
				System.out.println("Close database connection successfully");
			} catch (Exception e) {
				System.out.println("Someting went wrong when closing database connection");
				throw e;
			}
		}
	}
}
