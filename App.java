package com.jdbc.jdbcprograms.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
		Statement stmt = con.createStatement();
		String q = "insert into post(title,body) values('first post ever','body of the post')";
		int i = stmt.executeUpdate(q);

	}
}
