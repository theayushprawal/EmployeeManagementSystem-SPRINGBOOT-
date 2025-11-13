package com.ems.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Address;
import com.ems.entity.Employee;
import com.ems.exception.ResourceNotFound;
import com.ems.repository.AddressRepository;
import com.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee saveEmployeeDetails(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}

	public void register(String firstName, String lastName, String email, String mobile) {
		
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setEmail(email);
		emp.setMobile(mobile);
		employeeRepository.save(emp);
	}
	
	public List<Employee> getRegistrations(int pageNo, int pageSize, String sortBy, String sortDir) {
		
		Sort sort = sortDir.equalsIgnoreCase("DESC") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		
		Page<Employee> page = employeeRepository.findAll(pageable);
		List<Employee> employees = page.getContent();
		
		System.out.println(page.getNumber());
		System.out.println(page.getSize());
		System.out.println(page.getTotalPages());
		System.out.println(page.getTotalElements());
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getPageSize());
		System.out.println(page.isFirst());
		System.out.println(page.isLast());
		
		return employees;
		 
	}

	public void deleteRegistrationById(long id) {
		employeeRepository.deleteById(id);
		
	}

	public Employee getEmployeeById(long id) {
		Optional<Employee> opEmp = employeeRepository.findById(id);
		
		if(opEmp.isPresent()) {
			Employee employee = opEmp.get();
			return employee;
		}
		else {
			throw new ResourceNotFound("Employee not found with id " + id);
		}
		
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}

}