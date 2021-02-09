package groupeB2.ProjetPoc.Utils;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import groupeB2.ProjetPoc.dao.AdminRepository;
import groupeB2.ProjetPoc.dao.ManagerRepository;
import groupeB2.ProjetPoc.dao.ProjetRepository;
import groupeB2.ProjetPoc.dao.TempsRepository;
import groupeB2.ProjetPoc.dao.UserRepository;
import groupeB2.ProjetPoc.domain.Admin;
import groupeB2.ProjetPoc.domain.Manager;
import groupeB2.ProjetPoc.domain.Projet;
import groupeB2.ProjetPoc.domain.Temps;
import groupeB2.ProjetPoc.domain.User;


@Configuration

public class LoadDatabase {
	
	@Bean
	@Profile("!test")
	CommandLineRunner initDatabase(ProjetRepository projetRepository, TempsRepository tempsRepository, UserRepository userRepository, ManagerRepository managerRepository,AdminRepository adminRepository ) {
		
		return args -> {			
			initProjet(projetRepository);
			
			initTemps(tempsRepository);				
			
			initUser(userRepository);
			
			initManager(managerRepository);
			
			initAdmin(adminRepository);
			
			User albert = new User();
			albert.setLogin("zz");
			albert.setNom("einstein");
			albert.setPrenom("albert");
			albert.setPassword("ez");
			
				
			Manager manager1 = new Manager();
			manager1.setLogin("man2");
			manager1.setNom("mana2");
			manager1.setPrenom("aze2");
			manager1.setPassword("azerty2");
			managerRepository.save(manager1);
			Projet projet1= new Projet();
			projet1.setNom("POCa");
			manager1.addProjet(projet1);
			projetRepository.save(projet1);	
			manager1.addUser(albert);
			userRepository.save(albert);
			managerRepository.save(manager1);	
			projet1.addUser(albert);
			projetRepository.save(projet1);
			userRepository.save(albert);
			System.out.println(projet1.getUsers());
			Temps temps2=new Temps();
			temps2.setNbhours(2L);
			tempsRepository.save(temps2);
			albert.addTime(temps2, projet1);
			userRepository.save(albert);
			tempsRepository.save(temps2);
			
			Manager manager5 = new Manager();
			manager5.setLogin("man5");
			manager5.setNom("mana5");
			manager5.setPrenom("aze5");
			manager5.setPassword("azerty5");
			managerRepository.save(manager5);
		};
		
	}

	private void initAdmin(AdminRepository adminRepository) {
		// TODO Auto-generated method stub
		Admin admin1 = new Admin();
		admin1.setLogin("admin");
		admin1.setNom("adminnom");
		admin1.setPrenom("adminprenom");
		admin1.setPassword("admin");
		adminRepository.save(admin1);
		
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
	@Bean
	@Profile("test")
	CommandLineRunner initTestDatabase(ProjetRepository projetRepository, TempsRepository tempsRepository, UserRepository userRepository, ManagerRepository managerRepository,AdminRepository adminRepository ) {
		
		return args -> {			
			initProjet(projetRepository);
			
			initTemps(tempsRepository);				
			
			initUser(userRepository);
			
			initManager(managerRepository);
			
			initAdmin(adminRepository);
			
			
		};
		
	}
	
}
