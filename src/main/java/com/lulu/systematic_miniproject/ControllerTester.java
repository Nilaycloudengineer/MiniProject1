package com.lulu.systematic_miniproject;

import java.sql.SQLException;

import com.lulu.systematic_miniproject.BusinessLogic;

public class ControllerTester {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		BusinessLogic bl = new BusinessLogic();
		bl.createData();
		bl.readData();
		bl.deleteData();
		bl.updateData();

	}

}
