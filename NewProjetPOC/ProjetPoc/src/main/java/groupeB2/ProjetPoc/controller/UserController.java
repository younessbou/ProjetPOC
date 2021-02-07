package groupeB2.ProjetPoc.controller;

import java.util.Collection;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import groupeB2.ProjetPoc.Service.UserService;
import groupeB2.ProjetPoc.domain.Projet;
import groupeB2.ProjetPoc.domain.Temps;
import groupeB2.ProjetPoc.domain.User;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	Collection<User> findAllUsers() {
		return this.userService.findAllUsers();
	}
	
	@PostMapping("/users_time")
	Temps set_time(@Valid @RequestBody Temps temps) {
		
		return this.userService.Set_Time(temps);
	}
	
}
