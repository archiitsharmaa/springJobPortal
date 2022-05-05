package com.springJobPortal.customer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	 @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	    public String login(Model model, String error, String logout) {
		 
	        return "loginForm";
	    }
	
	@RequestMapping("/")
	public String newCustomerForm(Map<String, Object> model) {
		Customer customer = new Customer();
		
		model.put("customer", customer);
		return "new_customer";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
		
		String username= customer.getUsername();
		
		Customer objectExist = customerRepository.getUserByUsername(username);
		
		if(objectExist != null) {
			
			redirectAttributes.addAttribute("exists",true);
			
			return "redirect:/";
		}
		else {
		
		customerService.save(customer);
		return "redirect:/loginForm";
		}
	}
	
	@RequestMapping("/welcome")
	public String welcomeDasboard(Authentication authentication, Model model) {
		
		authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String username = authentication.getName();

		Customer customer = customerRepository.getUserByUsername(username);
		
		model.addAttribute(customer);
		
		
		return "welcome";
	}
	
	
	
}
