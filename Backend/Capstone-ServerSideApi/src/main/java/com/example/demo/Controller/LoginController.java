package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Login;
import com.example.demo.Repository.LoginRepository;
import com.example.demo.Exception.ResourceNotFoundException;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private LoginRepository loginRepo;
	
	@GetMapping("/validateUserLogin/{name}/{password}")
	public String validateUserLogin(@PathVariable String name, @PathVariable String password)
	{
		List<Login> allLoginUserInfo = loginRepo.findAll();
		
		   Login tempuser1 = allLoginUserInfo.stream()
		  .filter(lg -> name.equals(lg.getLoginName()))
		  .findAny()
		  .orElse(null);
		 
		   if(tempuser1 == null) {
			   return "No UserName found";
		   }
		   
		   Login tempuser2 = allLoginUserInfo.stream()
					  .filter(lg -> password.equals(lg.getLoginPassword()))
					  .findAny()
					  .orElse(null);
		   
		   if(tempuser2 == null) {
			   return "Password Incorrect";
		   }
		   
		   return "Successfully Logged In";
		 
	}
	
	@GetMapping("/validateUserLoginInfo")
	public String validateUserLoginInfo(@RequestBody Login login)
	{
		List<Login> allLoginUserInfo = loginRepo.findAll();
		
		   Login tempuser1 = allLoginUserInfo.stream()
		  .filter(lg -> login.getLoginName().equals(lg.getLoginName()))
		  .findAny()
		  .orElse(null);
		 
		   if(tempuser1 == null) {
			   return "User not found";
		   }
		   
		   Login tempuser2 = allLoginUserInfo.stream()
					  .filter(lg -> login.getLoginPassword().equals(lg.getLoginPassword()))
					  .findAny()
					  .orElse(null);
					  
		   if(tempuser2 == null) {
			   return "Password Incorrect";
		   }
		   
		   return "Successfully Logged In";
		 
	}
	
	@PostMapping("/addNewUserLogin")
    public String newUserLogin(@RequestBody Login login)
    {
		   List<Login> allLoginUserInfo = loginRepo.findAll();
		   Login tempuser1 = allLoginUserInfo.stream()
		  .filter(lg -> login.getLoginName().equals(lg.getLoginName()))
		  .findAny()
		  .orElse(null);
		 
		   if(tempuser1 != null) {
			   return "UserName already exists";
		   }
		  
		   
		loginRepo.save(login);
		
		return "User Successfully Created";
    }
	
	

}
