package groupeB2.ProjetPoc.domain;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
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
public class Projet {
	private @Id @GeneratedValue Long id;
	private String nom;
	

	
	@OneToMany
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties({"projets","tempss","manager","password","login"})
	private Set<Temps> tempss;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToMany
	@JsonIgnoreProperties({"projets","tempss","manager","password","login"})
	private Set<User> users;
	
	@ManyToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties({"users","tempss","manager","projets","password","login"})
	private Manager manager;
	
	public Projet(Long id, String nom) {
		super();
		this.nom = nom;
	}
	
	public Projet() {
		this.users = new HashSet<>();
		
		this.tempss=new HashSet<>();
	}

	
	
	public void addUser(User user) {
		
		user.getProjets().add(this);
		
		this.users.add(user);
	}
}
