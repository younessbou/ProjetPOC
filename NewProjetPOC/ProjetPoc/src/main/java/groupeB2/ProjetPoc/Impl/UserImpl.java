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
	public Temps Set_Time(long id1, long id2, long nbhours) {
		User user= userRepository.getOne(id1);
		Projet projet=projetRepository.getOne(id2);
		Temps temps=new Temps(nbhours);
		temps.setProjet(projet);
		temps.setUser(user);
		projetRepository.save(projet);
		userRepository.save(user);
		tempsRepository.save(temps);
		return temps;
	}
}
