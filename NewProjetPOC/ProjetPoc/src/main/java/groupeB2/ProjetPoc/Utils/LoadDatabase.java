package groupeB2.ProjetPoc.Utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import groupeB2.ProjetPoc.dao.ManagerRepository;
import groupeB2.ProjetPoc.dao.ProjetRepository;
import groupeB2.ProjetPoc.dao.TempsRepository;
import groupeB2.ProjetPoc.dao.UserRepository;
import groupeB2.ProjetPoc.domain.Manager;
import groupeB2.ProjetPoc.domain.Projet;
import groupeB2.ProjetPoc.domain.Temps;
import groupeB2.ProjetPoc.domain.User;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {
	
	@Bean
	@Profile("!test")
	CommandLineRunner initDatabase(ProjetRepository projetRepository, TempsRepository tempsRepository, UserRepository userRepository, ManagerRepository managerRepository ) {
		
		return args -> {			
			initProjet(projetRepository);
			
			initTemps(tempsRepository);				
			
			initUser(userRepository);
			
			initManager(managerRepository);
		};
		
	}

	private void initManager(ManagerRepository managerRepository) {
		// TODO Auto-generated method stub
		
		Manager manager1 = new Manager();
		manager1.setLogin("man1");
		manager1.setNom("mana1");
		manager1.setPrenom("aze");
		manager1.setPassword("azerty");
		managerRepository.save(manager1);
		
	}

	private void initUser(UserRepository userRepository) {
		// TODO Auto-generated method stub
		
		User albert = new User();
		albert.setLogin("zz");
		albert.setNom("einstein");
		albert.setPrenom("albert");
		albert.setPassword("ez");
		userRepository.save(albert);
		
		User albert1 = new User();
		albert1.setLogin("fr");
		albert1.setNom("rfrf");
		albert1.setPrenom("frrz");
		albert1.setPassword("azeza");
		userRepository.save(albert1);
		
	}
	
	

	private void initTemps(TempsRepository tempsRepository) {
		Temps temp1= new Temps();
		temp1.setNbhours(2);
		
	}

	private void initProjet(ProjetRepository projetRepository) {
		Projet projet1= new Projet();
		projet1.setNom("POC");
		projetRepository.save(projet1);
	}
	
}
