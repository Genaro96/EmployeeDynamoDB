package com.example.demo.repository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.EmployeesEntity;
import com.example.demo.modelo.dao.EmployeesDAO;
import com.example.demo.modelo.dao.IEmployeesDAO;
import com.example.demo.view.EmployeesView;

import jdk.jfr.BooleanFlag;

@Service
public class EmployeesService {
	@Autowired
	private IEmployeesDAO iEmployeesDAO;

	public void addEmployees(EmployeesView employeesView) {
		ModelMapper modelMap = new ModelMapper();
		EmployeesEntity employees = modelMap.map(employeesView, EmployeesEntity.class);
		this.iEmployeesDAO.addEmployees(employees);
	}

	public void updateEmployees(EmployeesView employeesView) {
		ModelMapper modelMap = new ModelMapper();
		EmployeesEntity employees = modelMap.map(employeesView, EmployeesEntity.class);
		this.iEmployeesDAO.updateEmployees(employees);
	}

	public void deleteEmployees(String employeesId) {
		iEmployeesDAO.deleteEmployees(employeesId);
	}

	public List<EmployeesView> selectEmployees() {
		List<EmployeesView> list = iEmployeesDAO.selectEmployees();
		return list;
	}

	public EmployeesView findEmployeesId(String employeesId) {
		this.iEmployeesDAO.findEmployeesId(employeesId);
		EmployeesEntity findEmployees = iEmployeesDAO.findEmployeesId(employeesId);
		ModelMapper modelMap = new ModelMapper();
		EmployeesView employeesView = modelMap.map(findEmployees, EmployeesView.class);
		return employeesView;

	}
}
