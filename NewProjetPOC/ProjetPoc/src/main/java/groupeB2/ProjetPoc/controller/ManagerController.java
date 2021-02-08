package groupeB2.ProjetPoc.controller;

import java.util.Collection;
import java.util.Set;

import javax.validation.Valid;

import org.apache.catalina.manager.ManagerServlet;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/managers_user/{id}")
	Manager add_user(@PathVariable(value = "id") Long id, @RequestBody String request) {
		JSONObject obj = new JSONObject(request);
		String nom=obj.getString("nom");
	
		String prenom = obj.getString("prenom");
		String password = obj.getString("password");
		String login = obj.getString("login");
		User user=new User(nom,prenom,password,login);
		return this.managersService.Add_user(id,user);
	}
	
	@PostMapping("/managers_projets/{id}")
	Manager add_projet(@PathVariable(value = "id") Long id, @RequestBody String request) {
		JSONObject obj = new JSONObject(request);
		String nom=obj.getString("nom");
		Projet projet=new Projet(nom);
		return this.managersService.Add_projet(id, projet);
	}
	
	@PostMapping("/managersaddprouser/{id}")
	Manager add_projet_to_user(@PathVariable(value = "id") Long id, @RequestBody String request) {
		JSONObject obj = new JSONObject(request);
		Long id1=obj.getLong("id1");
		Long id2=obj.getLong("id2");
		return this.managersService.Add_projet_to_user(id, id1,id2);
	}
	@GetMapping("/managers/times/{id}")
	Set<Temps> findAlltime(@PathVariable Long id){
		return this.managersService.findAllTime(id);
	}
}
