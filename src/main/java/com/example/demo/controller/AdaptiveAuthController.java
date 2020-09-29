package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.EmployeesService;
import com.example.demo.view.EmployeesView;

@RestController
public class AdaptiveAuthController {
	@Autowired
	private EmployeesService employeesService;

	@PostMapping("/employees")
	public ResponseEntity<?> addEmployees(@RequestBody EmployeesView employeesView) {
		employeesService.addEmployees(employeesView);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@PutMapping("/employees/{employeesId}")
	public ResponseEntity<?> updateEmployees(@PathVariable String employeesId,
			@RequestBody EmployeesView employeesView) {
		employeesView.setEmployeesId(employeesId);
		employeesService.updateEmployees(employeesView);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@DeleteMapping("/employees/{employeesId}")
	public void deleteEmployees(@PathVariable String employeesId) {
		employeesService.deleteEmployees(employeesId);
	}

	@GetMapping("/employees")
	public List<EmployeesView> selectEmployees() {
		List<EmployeesView> list = employeesService.selectEmployees();
		return list;
	}

	@GetMapping("/employees/{employeesId}")
	public ResponseEntity<EmployeesView> findEmployeesId(@PathVariable String employeesId) {
		employeesService.findEmployeesId(employeesId);
		EmployeesView findEmployees = employeesService.findEmployeesId(employeesId);
		ResponseEntity.status(HttpStatus.OK).body(employeesId);
		ResponseEntity<EmployeesView> reponse = ResponseEntity.status(HttpStatus.OK).body(findEmployees);
		return reponse;
	}
}
