package groupeB2.ProjetPoc.controller;

import java.util.Collection;
import org.json.*;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//Id1 l'id du user Id2 id du projet
	@PostMapping("/users_time/{id1}")
	Temps set_time(@PathVariable(value = "id1") Long id1, @RequestBody String request) {
		JSONObject obj = new JSONObject(request);
		Long id=obj.getLong("id");
		long nbhours=obj.getLong("nbhours");
		
		return this.userService.Set_Time(id1, id,nbhours);
	}
	
}
