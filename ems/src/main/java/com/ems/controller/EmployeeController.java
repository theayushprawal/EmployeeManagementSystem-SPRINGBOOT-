package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;
import com.ems.util.EmailService;

@Controller
public class EmployeeController {

	
	private EmployeeService employeeService;

	private EmailService emailService;

    public EmployeeController(EmployeeService employeeService, EmailService emailService) {
		this.employeeService = employeeService;
		this.emailService = emailService;
	} 			
    			//we removed @Autowired and generated constructor instead because during jUint testing we get a lot of boilerplate
    			//code if we do dependency injection using @Autowired; so we use constructors for dependency injection
    			//also tight coupling due to @Autowired

	//http://localhost:8080/view
	
	@RequestMapping("/view")
	public String viewRegisterPage() {
		return "registration";
	}
	
	
	@RequestMapping("/saveReg")
	public String getRegistrationData(@ModelAttribute EmployeeDto employeeDto, ModelMap model) {
		//employeeService.saveEmployeeDetails(employeeDto);
		model.addAttribute("msg", "Record is saved");
		emailService.sendEmail(employeeDto.getEmail(), "Test", "Welcome Test Message");
        return "registration";
	}
	
	@RequestMapping("/saveRegistration")
	public String getDataUsingRequestParam(
			 @RequestParam String firstName,
			 @RequestParam String lastName,
			 @RequestParam("emailId") String email,
			 @RequestParam String mobile
			) {
		
		employeeService.register(firstName,lastName,email,mobile);
		return "employee";
	}
	
	@RequestMapping("/viewRegistration")
	public String viewRegister() {
		return "employee";//--> RequestDispatcher
	}
	
	@RequestMapping("/listRegistrations")
	public String viewRegistrations(ModelMap model) {
		//List<Employee> employees = employeeService.getRegistrations();
		//model.addAttribute("employees",employees);
		return "list_registrations";//--> RequestDispatcher
	}
	
	@RequestMapping("/deleteEmployee")
	public String deleteRegistrations(@RequestParam long id, ModelMap model) {
		employeeService.deleteRegistrationById(id);
		
		//List<Employee> employees = employeeService.getRegistrations();
		//model.addAttribute("employees",employees);
		return "list_registrations";//--> RequestDispatcher
	}
	
	@RequestMapping("/getEmployee")
	public String getRegistrations(@RequestParam long id, ModelMap model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update_registration";
	}
	
	@RequestMapping("/updateReg")
	public String updateEmployeeData(Employee employee, ModelMap model) {
		employeeService.updateEmployee(employee);
		
		//List<Employee> employees = employeeService.getRegistrations();
		//model.addAttribute("employees",employees);
		return "list_registrations";//--> RequestDispatcher
	}
	
}