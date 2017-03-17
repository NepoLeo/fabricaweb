package br.com.fabricaweb.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabricaweb", "postgres", "ML141114");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return conn;

	}
	
	public static void main(String[] args) {
		getConnection();
	}

}
