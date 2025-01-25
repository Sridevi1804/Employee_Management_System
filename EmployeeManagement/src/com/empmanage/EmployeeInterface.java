package com.empmanage;

public interface EmployeeInterface {

	//1.create employee
	public void createEmployee(Employee emp);
	
	//2.view employee
	public void showAllEmployee();
	
	//3.show employee based on id
	public void showEmployeeBasedOnId(int id);
	
	//4.update employee
	public void updateEmployee(int id,String name);
	
	//5.delete employee
	public void deleteEmployee(int id);
}
