package groupeB2.ProjetPoc.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Manager {
private @Id @GeneratedValue long id;
	
	private String nom;
	private String prenom;
	private String password;
	private String login;
	public Manager(long id, String nom, String prenom, String password, String login) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.login = login;
	}
	public Manager() {
		// TODO Auto-generated constructor stub
	}

}
