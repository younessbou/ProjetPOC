package groupeB2.ProjetPoc.controller;

import java.util.Collection;
import java.util.Set;

import javax.validation.Valid;

import org.apache.catalina.manager.ManagerServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import groupeB2.ProjetPoc.Service.ManagerService;
import groupeB2.ProjetPoc.Service.UserService;
import groupeB2.ProjetPoc.domain.Manager;
import groupeB2.ProjetPoc.domain.Projet;
import groupeB2.ProjetPoc.domain.Temps;
import groupeB2.ProjetPoc.domain.User;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH})
public class ManagerController {

	@Autowired
	private ManagerService managersService;
	
	@GetMapping("/managers")
	Collection<Manager> findAllManagers() {
		return this.managersService.findAllManagers();
	}
	
	@PostMapping("/managers_user")
	Set<User> add_user(@Valid @RequestBody User user) {
		
		return this.managersService.Add_user(user);
	}
	
	@PostMapping("/managers_projets")
	Set<Projet> add_projet(@Valid @RequestBody Projet projet) {
		
		return this.managersService.Add_projet(projet);
	}
	
	@GetMapping("/managers/{id}/times")
	Set<Temps> findAlltime(Long  id){
		return this.managersService.findAllTime(id);
	}
}
