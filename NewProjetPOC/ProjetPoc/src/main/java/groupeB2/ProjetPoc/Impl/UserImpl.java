package groupeB2.ProjetPoc.Impl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
	@Autowired
	private ProjetRepository projetRepository;
	@Autowired
	private TempsRepository tempsRepository;
	
	@Override
	@Transactional
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<User> findUserById(Long id) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(id);
	}

	

	@Override
	@Transactional
	public Temps Set_Time(Long id1, Long id2, long nbhours) {
		User user= userRepository.getOne(id1);
		Set<Temps> tempss=user.getTempss();
		Iterator<Temps> iterator2=tempss.iterator();

		Temps temps2=new Temps();
		while(iterator2.hasNext()) {
			Projet proj=iterator2.next().getProjet();
			if(proj.getId()==id2) {
				Iterator<Temps> iterator3=proj.getTempss().iterator();
				while(iterator3.hasNext()){
					Temps temporary=iterator3.next();
					temporary.setNbhours(nbhours);
					tempsRepository.save(temporary);
					return null;
				}
			}
		}
		Set<Projet> projets=user.getProjets();
		Iterator<Projet> iterator = projets.iterator();
		Projet projet=null;
		while(iterator.hasNext()){
			Projet temporary=iterator.next();
			if (temporary.getId()==id2) {
				projet=temporary;
			} 
		}
		if(temps2.getId()==null) {
			temps2.setNbhours(nbhours);
			tempsRepository.save(temps2);
			user.addTime(temps2, projet);
			userRepository.save(user);
			return tempsRepository.save(temps2);
			
		}
		System.out.println("test");
		
		System.out.println("test2");
		return null;
	}
}
