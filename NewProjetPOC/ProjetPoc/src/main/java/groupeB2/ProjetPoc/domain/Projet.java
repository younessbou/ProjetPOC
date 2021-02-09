package groupeB2.ProjetPoc.domain;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
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
        @Index(name = "pmanager_index", columnList = "manager_id")
})
public class Projet {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String nom;
	

	
	@OneToMany  (mappedBy = "projet", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties({"projets","tempss","manager","password","login", "projet"})
	private Set<Temps> tempss;
	
	@ToString.Exclude
	@OnDelete(action = OnDeleteAction.CASCADE)
	@EqualsAndHashCode.Exclude
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"projets","tempss","manager","password","login"})
	private Set<User> users;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties({"users","tempss","manager","projets","password","login"})
	private Manager manager;
	
	public Projet(String nom) {
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
	
	 public void removeUser(User user) {
	        users.remove(user);
	        user.getProjets().remove(this);
	    }
	 
	 public void removeTimeCheck(Temps temps) {
	        tempss.remove(temps);
	        temps.setProjet(null);
	    }
}
