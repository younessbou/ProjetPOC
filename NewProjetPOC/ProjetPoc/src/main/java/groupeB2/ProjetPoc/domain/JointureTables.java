package groupeB2.ProjetPoc.domain;

import java.util.Set;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

public class JointureTables {
	
	@Id
	@ManyToMany
	@JoinColumn(name = "Temps", referencedColumnName = "id")
	private Set<Temps> temps;
	
	@Id
	@ManyToMany 
	@JoinColumn(name = "User", referencedColumnName = "id")
	private Set<User> users;
	
	@Id
	@ManyToMany 
	@JoinColumn(name = "Projet", referencedColumnName = "id")
	private Set<Projet> projets;
	
}
