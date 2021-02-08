package groupeB2.ProjetPoc.Utils;

import java.util.Optional;

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


@Configuration

public class LoadDatabase {
	
	@Bean
	@Profile("!test")
	CommandLineRunner initDatabase(ProjetRepository projetRepository, TempsRepository tempsRepository, UserRepository userRepository, ManagerRepository managerRepository ) {
		
		return args -> {			
			initProjet(projetRepository);
			
			initTemps(tempsRepository);				
			
			initUser(userRepository);
			
			initManager(managerRepository);
			
			User albert = new User();
			albert.setLogin("zz");
			albert.setNom("einstein");
			albert.setPrenom("albert");
			albert.setPassword("ez");
			
			
			Projet projet1= new Projet();
			projet1.setNom("POCa");
			projetRepository.save(projet1);		
			Temps temp1= new Temps();
			
			temp1.setNbhours(2);
			tempsRepository.save(temp1);
			albert.addProjet(projet1);

			userRepository.save(albert);
			tempsRepository.save(temp1);	
			Manager manager1 = new Manager();
			manager1.setLogin("man2");
			manager1.setNom("mana2");
			manager1.setPrenom("aze2");
			manager1.setPassword("azerty2");
			manager1.addProjet(projet1);
			manager1.addUser(albert);
			managerRepository.save(manager1);
			projetRepository.save(projet1);	
			userRepository.save(albert);
			
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
		Projet projet2= new Projet();
		projet2.setNom("POCb");
		projetRepository.save(projet2);
	}
	
}
