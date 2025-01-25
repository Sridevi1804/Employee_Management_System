package com.empmanage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeImplement implements EmployeeInterface {

	Connection con;
	
	public void createEmployee(Employee emp) {
		con = DBConnection.createDBConnection();
		String query = "insert into employee values(?,?,?,?)";
		
		try {
			//creating statement
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,emp.getId());
			ps.setString(2, emp.getName());
			ps.setInt(3, emp.getSalary());
			ps.setInt(4, emp.getAge());
			
			//execute statement(query)
			
			int count = ps.executeUpdate();
			if (count>0)
				System.out.println("Employee inserted successfully\n");
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showAllEmployee() {
		con = DBConnection.createDBConnection();
		String query = "select * from employee";
		System.out.println("Employee Details");
		System.out.println("-------------------------------------------------------------------------");
		System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","age");
		System.out.println("-------------------------------------------------------------------------");

		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			
			
			while(result.next()) {
				System.out.format("%d\t%s\t%d\t%d\n",
								  result.getInt(1),
								  result.getString(2),
								  result.getInt(3),
								  result.getInt(4));
				System.out.println("-------------------------------------------------------------------------");
			}
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void showEmployeeBasedOnId(int id) {
		
		con = DBConnection.createDBConnection();
		String query = "select * from employee where id="+id;
		
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			
			
			while(result.next()) {
				System.out.format("%d\t%s\t%d\t%d\n",
								  result.getInt(1),
								  result.getString(2),
								  result.getInt(3),
								  result.getInt(4));			}
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void updateEmployee(int id, String name) {
		
		con = DBConnection.createDBConnection();
		String query = "update employee set name=? where id=?";
		
		try {
			//creating statement
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,name);
			ps.setInt(2,id);
			
			//execute statement(query)
			
			int count = ps.executeUpdate();
			if (count!=0)
				System.out.println("Employee details updated successfully\n");
		} 
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void deleteEmployee(int id) {
		con = DBConnection.createDBConnection();
		String query = "delete from employee where id=?";
		
		try {
			//creating statement
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,id);
			
			//execute statement(query)
			
			int count = ps.executeUpdate();
			if (count!=0)
				System.out.println("Employee details deleted successfully\n");
		} 
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
