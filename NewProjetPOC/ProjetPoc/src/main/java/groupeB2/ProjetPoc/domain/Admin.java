package groupeB2.ProjetPoc.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Admin {
	
	private @Id @GeneratedValue long id;
	
	private String nom;
	private String prenom;
	private String password;
	private String login;
	
	public Admin(String nom, String prenom, String password, String login) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.login = login;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}
}
