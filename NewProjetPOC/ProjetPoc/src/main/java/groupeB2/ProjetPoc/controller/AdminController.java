package groupeB2.ProjetPoc.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import groupeB2.ProjetPoc.Service.AdminService;
import groupeB2.ProjetPoc.domain.Manager;
import groupeB2.ProjetPoc.domain.User;
import groupeB2.ProjetPoc.domain.Admin;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH})
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	//Indiquer l'ID du user que l'on passe manager
	@PatchMapping("/admin/Matous")
	Manager changeUserToManager(@PathVariable Long id) {
		return this.adminService.changeUserToManager(id);
	}
	
	@GetMapping("/admin")
	Collection<Admin> findAllAdmin() {
		return this.adminService.findAllAdmin();
	}
	
	//Id1 l'id du user Id2 id du nouveau manager
	@PatchMapping("/admin/ChangeManager")
	User changeManager(@PathVariable Long id1, @PathVariable Long id2) {
		return this.adminService.changeManager(id1,id2);
	}
}
