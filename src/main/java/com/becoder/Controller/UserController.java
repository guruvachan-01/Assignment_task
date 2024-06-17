package com.becoder.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


import com.becoder.Repository.UserRepo;
import com.becoder.Service.UserService;
import com.becoder.model.User;


import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {
	 
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/users")
	public String getAllUser(Model model) {
		List<User> user=userService.getAlluser();
		model.addAttribute("users", user);
		return "users";
	}
	
	
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user, HttpSession session, Model m) {

	

		User u = userService.saveUser(user);

		if (u != null) {
			
			session.setAttribute("msg", "Register successfully");
			

		} else {
			// System.out.println("error in server");
			session.setAttribute("msg", "Something wrong server");
		}
		return "redirect:/register";
	}


	}
	
