package com.cts.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.EmployeeDAO;
import com.cts.model.Employee;

@Service
public class EmployeeBO {

@Autowired
EmployeeDAO employeeDAO;

public boolean registerEmployee(Employee employee) {

if(employee.getSalary()<20000) {
employee.setSalary(employee.getSalary()+employee.getSalary()*10/100);
}

return employeeDAO.employeeInsert(employee);
}
public Employee getEmployee(int id)
{
  
    Employee employee=employeeDAO.employeeSearch(id);
	return employee;
}
public List<Employee> listAllEmployee()
{
	
	List<Employee> list=employeeDAO.getAllEmployee();
	return list;
}

}