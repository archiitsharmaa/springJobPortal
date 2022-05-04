package com.springJobPortal.customer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//declares the class config as the controller to map urls 
@Controller
public class CustomerController {

	// accesses the service layer in the jpa for the customer entity
	@Autowired
	private CustomerService customerService;

	// accesses the repository layer in the jpa for the customer entity
	@Autowired
	private CustomerRepository customerRepository;

	// mapping to the login form
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {

		return "loginForm";
	}

	// deafult mapping, maps to the signup page
	@RequestMapping("/")
	public String newCustomerForm(Map<String, Object> model) {

		// intializes and saves the customer object from the signup page feilds
		Customer customer = new Customer();

		model.put("customer", customer);
		return "new_customer";
	}

	// action carried on register button
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {

		// fetches the uername of the signup form
		String username = customer.getUsername();

		// fetches the object from the username passed
		Customer objectExist = customerRepository.getUserByUsername(username);

		// checks if the username fetches the object if true, username exists and needs to be changed
		if (objectExist != null) {

			// adds param of usename exists to check of usename
			redirectAttributes.addAttribute("exists", true);

			return "redirect:/";
		} else {

			// saves the page and redirects to login
			customerService.save(customer);
			return "redirect:/loginForm";
		}
	}

	// maps to welcome page for every user
	@RequestMapping("/welcome")
	public String welcomeDasboard(Authentication authentication, Model model) {

		// fetches security context after login
		authentication = SecurityContextHolder.getContext().getAuthentication();

		// fetches uername from the authentication
		String username = authentication.getName();

		// gets the user object from the logged in username
		Customer customer = customerRepository.getUserByUsername(username);

		// adds the pbject
		model.addAttribute(customer);

		return "welcome";
	}

}
