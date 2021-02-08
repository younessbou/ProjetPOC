package groupeB2.ProjetPoc.Impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import groupeB2.ProjetPoc.Service.ManagerService;
import groupeB2.ProjetPoc.dao.ManagerRepository;
import groupeB2.ProjetPoc.dao.ProjetRepository;
import groupeB2.ProjetPoc.dao.TempsRepository;
import groupeB2.ProjetPoc.dao.UserRepository;
import groupeB2.ProjetPoc.domain.Manager;
import groupeB2.ProjetPoc.domain.Projet;
import groupeB2.ProjetPoc.domain.Temps;
import groupeB2.ProjetPoc.domain.User;

@Service
public class ManagerImpl implements ManagerService {

	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private ProjetRepository projetRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TempsRepository tempsRepository;
	
	@Override
	@Transactional
	public List<Manager> findAllManagers() {
		// TODO Auto-generated method stub
		return this.managerRepository.findAll();
	}

	@Override
	@Transactional
	public Manager Add_user(Long id,User user) {
		userRepository.save(user);
		Manager manager=managerRepository.getOne(id);
		manager.addUser(user);
		managerRepository.save(manager);
		return null;
	}

	@Override
	@Transactional
	public Manager Add_projet(Long id,Projet projet) {
		Manager manager=managerRepository.getOne(id);
		manager.addProjet(projet);
		projetRepository.save(projet);
		managerRepository.save(manager);
		return null;
	}

	@Override
	@Transactional
	public Set<Temps> findAllTime(Long id) {
		Manager manager=managerRepository.getOne(id);
		Set<Temps> Tempss=new HashSet<Temps>() ;
		Set<User> Users=manager.getUsers();
		Iterator<User> it = Users.iterator();
		
	    while(it.hasNext()) {
	    	Iterator<Temps> it2 = it.next().getTempss().iterator();
	    	while(it2.hasNext())
	    	{
	    		Tempss.add(it2.next());
	    	}
	    }
		return Tempss;
	}

	@Override
	@Transactional
	public Manager Add_projet_to_user(Long id, Long id1, Long id2) {
		Projet projet=projetRepository.getOne(id1);
		User user=userRepository.getOne(id2);
		projet.addUser(user);
		Temps temps=new Temps(0L);
		tempsRepository.save(temps);
		user.addTime(temps, projet);
		userRepository.save(user);
		return null;
	}

}
