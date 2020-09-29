package com.example.demo.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class EmployeesEntity {
	private String employeesId;
	private String name;
	private String firtName;
	private String lastName;
	private String employeeAge;
	private String employeeDate;
	/**
	 * @return the employeesId
	 */
	@DynamoDbPartitionKey
	@DynamoDbAttribute("Employees_Id")
	public String getEmployeesId() {
		return employeesId;
	}
	
	/**
	 * @param employeesId the employeesId to set
	 */
	public void setEmployeesId(String employeesId) {
		this.employeesId = employeesId;
	}
	/**
	 * @return the name
	 */
	@DynamoDbAttribute("Name")
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the firtName
	 */
	@DynamoDbAttribute("First_Name")
	public String getFirtName() {
		return firtName;
	}
	/**
	 * @param firtName the firtName to set
	 */
	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}
	/**
	 * @return the lastName
	 */
	@DynamoDbAttribute("Last_Name")
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the employeeAge
	 */
	@DynamoDbAttribute("Employee_Age")
	public String getEmployeeAge() {
		return employeeAge;
	}
	/**
	 * @param employeeAge the employeeAge to set
	 */
	public void setEmployeeAge(String employeeAge) {
		this.employeeAge = employeeAge;
	}
	/**
	 * @return the employeeDate
	 */
	@DynamoDbAttribute("Employee_Date")
	public String getEmployeeDate() {
		return employeeDate;
	}
	/**
	 * @param employeeDate the employeeDate to set
	 */
	public void setEmployeeDate(String employeeDate) {
		this.employeeDate = employeeDate;
	}
	@Override
	public String toString() {
		return "Employees [employeesId=" + employeesId + ", name=" + name + ", firtName=" + firtName + ", lastName="
				+ lastName + ", employeeAge=" + employeeAge + ", employeeDate=" + employeeDate + "]";
	}
}
