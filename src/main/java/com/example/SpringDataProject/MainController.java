package com.example.SpringDataProject;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)

public class MainController 
{
	@Autowired 
	private UserRepository userRepository;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) 
	{
		System.out.println("inside add" +name +" "+email);
		Customer userobj = new Customer();
		userobj.setName(name);
		userobj.setEmail(email);
		userRepository.save(userobj);
		//userRepository.
		//userRepository.
		return "Saved";
	}
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Customer> getAllUsers()
	{
		// This returns a JSON or XML with the users
		System.out.println("inside all");
		return userRepository.findAll();
	}
	
	
	@GetMapping(path="/allbyid")
	public @ResponseBody Optional<Customer> getAllUserbyid()
	{
		// This returns a JSON or XML with the users
		System.out.println("inside all");
		return userRepository.findById(4);
	}
	
	
	@GetMapping(path="/isExist")
	public @ResponseBody boolean isExist() 
	{
		// This returns a JSON or XML with the users
		System.out.println("inside all");
		return userRepository.existsById(4);
	}
	
	
	@PostMapping(path="/delete")
	public @ResponseBody String deleteUsers(@RequestParam String id ) 
	{
		// This returns a JSON or XML with the user
		int ids = Integer.parseInt(id);
		System.out.println("inside all");
		userRepository.deleteById(ids);
		return "Success";
	}
	
	
	@PostMapping(path="/update")
	public @ResponseBody String updateUsers(@RequestParam String id, @RequestParam String name,@RequestParam String email) 
	{
		// This returns a JSON or XML with the user
		int ids = Integer.parseInt(id);
		System.out.println("inside all");
		userRepository.deleteById(ids);
		return "Success";
	}
}