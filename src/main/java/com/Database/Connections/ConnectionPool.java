package com.Database.Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class ConnectionPool {
	private static BasicDataSource connectionPool;
	static {
		//
		connectionPool = new BasicDataSource();
		connectionPool.setUrl("jdbc:mysql://localhost:3306/journalcode");
		connectionPool.setDriverClassName("com.mysql.cj.jdbc.Driver");
		connectionPool.setUsername("todoadmins");
		connectionPool.setPassword("todo@111");

		connectionPool.setMinIdle(5);
		connectionPool.setMaxIdle(10);
	}

	public static Connection getConnection() {
		try {
			return connectionPool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
    
}