package com.lulu.systematic_miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class BusinessLogic {

	// CRUD Operations

	public void createData() throws SQLException {
		Connection connection = ConnectDB.setupConnection();
		String query = "INSERT INTO product ( id, name, cost , description ) VALUES( ?, ?,?,?)";

		PreparedStatement myStmt = connection.prepareStatement(query);
		myStmt.setInt(1, 777);
		myStmt.setString(2, "Avocado");
		myStmt.setInt(3, 620);
		myStmt.setString(4, "Contains fiber, aiding in digestion and weight management");

		int success = myStmt.executeUpdate();
		System.out.println("Added Successfully " + success);

	}

	public void readData() throws SQLException {
		Connection connection = ConnectDB.setupConnection();

		Statement statement;
		statement = connection.createStatement();
		ResultSet resultSet;
		resultSet = statement.executeQuery("select * from product where id>=111");
		int id;
		int cost;
		String name;
		String description;
		while (resultSet.next()) {
			id = resultSet.getInt("id");
			name = resultSet.getString("name");
			cost = resultSet.getInt("cost");
			description = resultSet.getString("description");
			System.out.println("id : " + id + " name : " + name + "  description:" + description + "cost :" + cost);
		}

	}

	void updateData() throws SQLException {

		Connection connection = ConnectDB.setupConnection();
		String query = "update product set name= ? where id = ? ";
		PreparedStatement myStmt = connection.prepareStatement(query);
		myStmt.setString(1, "Berries");
		myStmt.setInt(2, 333);
		boolean success = myStmt.execute();
		System.out.println("Deleted Successfully " + success);

	}

	void deleteData() throws SQLException {
		Connection connection = ConnectDB.setupConnection();
		String query = "delete from product where id = ? ";
		PreparedStatement myStmt = connection.prepareStatement(query);
		myStmt.setInt(1, 222);
		boolean success = myStmt.execute();
		System.out.println("Deleted Successfully " + success);

	}

}
