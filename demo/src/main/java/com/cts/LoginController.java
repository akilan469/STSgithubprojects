package com.cts;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cts.model.Employee;
import com.cts.service.EmployeeBO;

@Controller
public class LoginController 
{
	@RequestMapping("/index")
 public String showIndex()
 {
	 return "index";
 }
	@Autowired
	EmployeeBO employeeBO;
	
	@RequestMapping(value="/LoginForm",method=RequestMethod.POST)
	public String doLogin(String user,String password ,Model model)
	{
		if(user.equals("ctsuser") && password.equals("1234"))
		{
			model.addAttribute("name",user);
			System.out.println("Equals statement");
		    return "home";
		}
		else 
		{
			model.addAttribute("error", "Invalid user and password");
			System.out.println("not eq statement");

			return "index";
		}
	}
	
   @GetMapping("/registerEmployee")	
	public String registerForm(@ModelAttribute("employee") Employee employee,Model model)
	{
	   model.addAttribute("reg","reg");
	   model.addAttribute("list",Arrays.asList(new String[]{"Associate Director","Producer","Coach","Manager"}));
		return "home";
	}
	
	@RequestMapping(value="/employeeRegister",method=RequestMethod.POST)
	public String goo(@Valid @ModelAttribute("employee") Employee employee,BindingResult result ,RedirectAttributes redirectAttr)
	{
		if(result.hasErrors())
		{
			return "register";
		}
		
		if(employeeBO.registerEmployee(employee))
		{
			redirectAttr.addFlashAttribute("emp",employee);
			return "redirect:/toSuccess";	     
			}
		return "register";
	 }
	
	@GetMapping("/toSuccess")
	public String success(Model model)
	{
		model.addAttribute("success", "success");
		return "home";
	}
}
