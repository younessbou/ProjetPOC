package groupeB2.ProjetPoc.domain;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(indexes = {
        @Index(name = "temps_user_index", columnList = "user_id"),
        @Index(name = "temps_projet_index", columnList = "projet_id")
})
public class Temps {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
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
	
	
	public Temps(long nbhours) {
		this.nbhours = nbhours;
	}
	

	public Temps() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}






