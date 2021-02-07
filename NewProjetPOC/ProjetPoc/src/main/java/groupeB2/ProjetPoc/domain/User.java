package groupeB2.ProjetPoc.domain;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class User {
	private @Id @GeneratedValue long id;
	
	private String nom;
	private String prenom;
	private String password;
	private String login;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany
	@JsonIgnoreProperties({"users","tempss","password","login"})
	private Set<Projet> projets;
	
	@OneToMany 
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties({"user","tempss","password","login"})
	private Set<Temps> tempss;
	
	
	@ManyToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties({"users","tempss","projets","password","login"})
	private Manager manager;
	
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
		
		this.tempss= new HashSet<>();
	}
	
	public void addProjet(Projet proj) {
		proj.getUsers().add(this);
		this.getProjets().add(proj);
	}
	public void addTime(Temps time,Projet proj) {
		proj.getTempss().add(time);
		time.setUser(this);
		time.setProjet(proj);
		this.getTempss().add(time);
	}
}
