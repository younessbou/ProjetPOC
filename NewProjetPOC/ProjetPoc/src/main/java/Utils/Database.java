package Utils;



import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import TimeRepository.ProjetRepository;
import TimeRepository.TempsRepository;
import TimeRepository.UserRepository;
import groupeB2.ProjetPoc.domain.Projet;
import groupeB2.ProjetPoc.domain.Temps;
import groupeB2.ProjetPoc.domain.User;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j

public class Database {
	@Bean
	@Profile("!test")
	CommandLineRunner initDatabase(ProjetRepository projetRepository, TempsRepository tempsRepository, UserRepository userRepository ) {
		
		return args -> {			
			initProjet(projetRepository);
			
			initTemps(tempsRepository);				
			
			initUser(userRepository);
		};
		
	}

	private void initUser(UserRepository userRepository) {
		// TODO Auto-generated method stub
		
		User albert = new User();
		albert.setLogin("zz");
		albert.setNom("einstein");
		albert.setPrenom("albert");
		albert.setPassword("ez");
		
	}
	

	private void initTemps(TempsRepository tempsRepository) {
		Temps temp1= new Temps();
		temp1.setNbhours(2);
		
	}

	private void initProjet(ProjetRepository projetRepository) {
		Projet projet1= new Projet();
		projet1.setNom("POC");
	}
	
}
