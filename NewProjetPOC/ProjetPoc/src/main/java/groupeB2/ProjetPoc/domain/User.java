package groupeB2.ProjetPoc.domain;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(indexes = {
        @Index(name = "umanager_index", columnList = "manager_id")
})
public class User {
	private @Id @GeneratedValue (strategy = GenerationType.IDENTITY) long id;
	
	private String nom;
	private String prenom;
	private String password;
	private String login;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"users","tempss","password","login"})
	private Set<Projet> projets;
	
	@OneToMany (mappedBy="user", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties({"user","tempss","password","login"})
	private Set<Temps> tempss;
	
	
	@ManyToOne 
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties({"users","tempss","projets","password","login"})
	private Manager manager;
	
	public User(String nom, String prenom, String password, String login) {
		
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
	
	  public void removeProject(Projet projet) {
	        projets.remove(projet);
	        projet.getUsers().remove(this);
	    }
	  public void removeTimeCheck(Temps temps) {
	        tempss.remove(temps);
	        temps.setUser(null);
	    }
	

}
