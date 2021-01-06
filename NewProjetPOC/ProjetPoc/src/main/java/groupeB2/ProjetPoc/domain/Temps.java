package groupeB2.ProjetPoc.domain;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public class Temps {
	private @Id Long id;
	private long nbhours;
	
	public Temps(Long id, long nbhours) {
		this.id = id;
		this.nbhours = nbhours;
	}

	public Temps() {
		super();
		// TODO Auto-generated constructor stub
	}
}






