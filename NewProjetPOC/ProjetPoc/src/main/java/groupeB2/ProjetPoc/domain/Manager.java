package groupeB2.ProjetPoc.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany (mappedBy = "manager", fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"projets","tempss","projet","manager","password","login"})
	private Set<User> users;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
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
	
	
	public void addUserAndProjet(Projet projet, User user) {
		projet.setManager(this);
		user.setManager(this);
		this.getProjets().add(projet);
		this.getUsers().add(user);
	}


	public void addProjet(Projet proj) {
		proj.setManager(this);
		this.getProjets().add(proj);
		
	}


	public void addUser(User user) {
		user.setManager(this);
		this.getUsers().add(user);
	}

}
