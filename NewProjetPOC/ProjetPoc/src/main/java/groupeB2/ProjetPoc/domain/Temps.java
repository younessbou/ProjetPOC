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
	private @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	private long nbhours;
	
	@ManyToOne 
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties({"tempss","projets","manager","password","login"})
	User user;
	
	@ManyToOne 
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties({"tempss","users","manager","password","login"})
	Projet projet;
	
	
	public Temps(Long id, long nbhours) {
		this.id = id;
		this.nbhours = nbhours;
	}
	

	public Temps() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}






