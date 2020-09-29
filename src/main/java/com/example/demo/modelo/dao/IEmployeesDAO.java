package com.example.demo.modelo.dao;

import java.util.List;
import com.example.demo.model.EmployeesEntity;
import com.example.demo.view.EmployeesView;


public interface IEmployeesDAO {
	
	public void addEmployees(EmployeesEntity employees);

	public void updateEmployees(EmployeesEntity employees);

	public void deleteEmployees(String employeesId);

	public List<EmployeesView> selectEmployees();

	public EmployeesEntity findEmployeesId(String employeesId);
}
