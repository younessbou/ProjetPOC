package groupeB2.ProjetPoc.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class User {
	private @Id long id;
	
	private String nom;
	private String prenom;
	private String password;
	private String login;
	
	
	@ManyToMany 
	private Set<Temps> temps;
	
	@ManyToMany 
	private Set<Projet> projets;
	
	public User(long id, String nom, String prenom, String password, String login) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.login = login;
	}

	public User() {
		
		this.projets = new HashSet<>();
	}
	
	
	public void addProjet(Projet projet) {
		
		projet.getUsers().add(this);
		this.projets.add(projet);
	}
}
