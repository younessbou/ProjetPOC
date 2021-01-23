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

import lombok.Data;

@Data
@Entity
public class Projet {
	private @Id @GeneratedValue Long id;
	private String nom;
	
	//@ManyToMany(mappedBy="projets", fetch=FetchType.EAGER)
	//private Set<User> users;
	
	//@ManyToMany
	//private Set<Temps> temps;

	public Projet(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
		//this.users = users;
		//this.temps = temps;
	}

	public Projet() {
		//this.users = new HashSet<>();
	}

	
}
