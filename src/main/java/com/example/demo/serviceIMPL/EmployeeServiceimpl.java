package com.example.demo.serviceIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.respository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		
		Employee emp = employeeRepository.save(employee);
		return emp;
	}

	@Override
	public String removeEmployee(int id) {
		
		employeeRepository.deleteById(id);
		return "Deleted data successfully";
	}

	@Override
	public Optional<Employee> findEmpById(int id) {
		
		Optional<Employee> emp =  employeeRepository.findById(id);
		if(emp.isPresent()) {
			return emp;
		}
		else {
			return null;
			}
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> empList= employeeRepository.findAll();
		return empList;
	}

	@Override
	public String updateEmployee(int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			Employee emps = new Employee();
			employeeRepository.save(emps);
			return "Updated Successfully";
		}
		else {
			return "Employee Not Found";
		}
}
}
