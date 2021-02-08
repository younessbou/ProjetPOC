package groupeB2.ProjetPoc.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Manager {
private @Id @GeneratedValue long id;
	
	private String nom;
	private String prenom;
	private String password;
	private String login;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany 
	@JsonIgnoreProperties({"projets","tempss","projet","manager","password","login"})
	private Set<User> users;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany
	@JsonIgnoreProperties({"projets","tempss","users","password","login"})
	private Set<Projet> projets;
	
	public Manager( String nom, String prenom, String password, String login) {
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.login = login;
	}
	
	
	public Manager() {
		
		this.projets = new HashSet<>();
		
		this.users= new HashSet<>();
	}
	
	
	public void addUser(User user) {
		user.setManager(this);
		this.getUsers().add(user);
	}
		
	public void addProjet(Projet proj) {
		proj.setManager(this);
		this.getProjets().add(proj);
		
	}
}
