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
	
	@Override
	@Transactional
	public List<Manager> findAllManagers() {
		// TODO Auto-generated method stub
		return this.managerRepository.findAll();
	}

	@Override
	@Transactional
	public Set<User> Add_user(@Valid User user) {
		Manager manager=user.getManager();
		manager.addUser(user);
		return manager.getUsers();
	}

	@Override
	@Transactional
	public Set<Projet> Add_projet(@Valid Projet projet, Long id) {
		Manager manager=managerRepository.getOne(id);
		manager.addProjet(projet);
		projetRepository.save(projet);
		managerRepository.save(manager);
		return manager.getProjets();
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

}
