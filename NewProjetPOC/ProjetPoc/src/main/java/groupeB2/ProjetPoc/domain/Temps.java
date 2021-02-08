package groupeB2.ProjetPoc.domain;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Temps {
	@Id @GeneratedValue 
	private  Long id;
	private long nbhours;
	
	@ManyToOne 
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties({"tempss","projets","manager","password","login", "projet"})
	User user;
	
	@ManyToOne 
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties({"tempss","users","manager","password","login", "projet"})
	Projet projet;
	
	
	public Temps(long nbhours, Long id) {
		this.id = id;
		this.nbhours = nbhours;
	}
	

	public Temps() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}






