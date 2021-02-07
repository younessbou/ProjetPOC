package groupeB2.ProjetPoc.Impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupeB2.ProjetPoc.Service.UserService;
import groupeB2.ProjetPoc.dao.ProjetRepository;
import groupeB2.ProjetPoc.dao.TempsRepository;
import groupeB2.ProjetPoc.dao.UserRepository;
import groupeB2.ProjetPoc.domain.Projet;
import groupeB2.ProjetPoc.domain.Temps;
import groupeB2.ProjetPoc.domain.User;

@Service
public class UserImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	private ProjetRepository projetRepository;
	private TempsRepository tempsRepository;
	
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	@Override
	public Optional<User> findUserById(Long id) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(id);
	}

	@Override
	public Temps Set_Time(@Valid Temps temps) {
		Projet projet=temps.getProjet();
		projetRepository.save(projet);
		User user=temps.getUser();
		userRepository.save(user);
		return tempsRepository.save(temps);
	}


}
