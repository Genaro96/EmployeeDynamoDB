package com.example.demo.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeesEntity;
import com.example.demo.view.EmployeesView;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;

@Repository
public class EmployeesDAO implements IEmployeesDAO{
	@Autowired
	private DynamoDbEnhancedClient ddb;

	public void addEmployees(EmployeesEntity employees) {
		DynamoDbTable<EmployeesEntity> custTable = ddb.table("Employees", TableSchema.fromBean(EmployeesEntity.class));
		custTable.putItem(employees);
	}

	public void updateEmployees(EmployeesEntity employees) {
		DynamoDbTable<EmployeesEntity> custtable = ddb.table("Employees", TableSchema.fromBean(EmployeesEntity.class));
		custtable.putItem(employees);
	}

	public void deleteEmployees(String employeesId) {
		Key key = Key.builder().partitionValue(employeesId).build();
		DynamoDbTable<EmployeesEntity> custTable = ddb.table("Employees", TableSchema.fromBean(EmployeesEntity.class));
		custTable.deleteItem(key);
	}

	public List<EmployeesView> selectEmployees() {
		DynamoDbTable<EmployeesEntity> custTable = ddb.table("Employees", TableSchema.fromBean(EmployeesEntity.class));
		PageIterable<EmployeesEntity> page = custTable.scan();
		ArrayList<EmployeesView> list = new ArrayList<>();
		ModelMapper modelMap = new ModelMapper();
		for (Page<?> pagei : page) {
			List<?> item = pagei.items();
			for (Object obejct : item) {
				EmployeesEntity employees = (EmployeesEntity) obejct;
				EmployeesView employeesView = modelMap.map(employees, EmployeesView.class);
				list.add(employeesView);
			}
		}
		return list;

	}

	public EmployeesEntity findEmployeesId(String employeesId) {
		Key key = Key.builder().partitionValue(employeesId).build();
		DynamoDbTable<EmployeesEntity> custTable = ddb.table("Employees", TableSchema.fromBean(EmployeesEntity.class));
		custTable.getItem(key);
		EmployeesEntity custT = custTable.getItem(key);
		return custT;
	}
}
