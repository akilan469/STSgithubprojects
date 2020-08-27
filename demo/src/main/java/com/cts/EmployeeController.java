package com.cts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.model.Employee;
import com.cts.service.EmployeeBO;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeBO employeeBO;
	
	@GetMapping("/showEmployee")
	public String showEmployee(Model model) {
		model.addAttribute("searchForm", "searchForm");
		return "home";
	}

	@GetMapping("/searchEmployee")
	public ModelAndView employeeSearch(int id) 
	{
		
		ModelAndView mv = new ModelAndView();
		
		Employee employee = employeeBO.getEmployee(id);
		mv.addObject("emp",employee);
		mv.setViewName("showEmployee");
		
		return mv;
		
	}
	
	
	@GetMapping("/listEmployee")
	public ModelAndView listAllEmployee() {
		
		ModelAndView mv = new ModelAndView("listAllEmp");
		
		List<Employee> list = employeeBO.listAllEmployee();
		 mv.addObject("empList", list);
		 
		return mv;
		

	}
	
	
	
	
	
	
	
	
	
}
