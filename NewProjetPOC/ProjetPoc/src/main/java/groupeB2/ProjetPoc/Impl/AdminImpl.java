package groupeB2.ProjetPoc.Impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groupeB2.ProjetPoc.Service.AdminService;
import groupeB2.ProjetPoc.dao.AdminRepository;
import groupeB2.ProjetPoc.dao.ManagerRepository;
import groupeB2.ProjetPoc.dao.ProjetRepository;
import groupeB2.ProjetPoc.dao.UserRepository;
import groupeB2.ProjetPoc.domain.Admin;
import groupeB2.ProjetPoc.domain.Manager;
import groupeB2.ProjetPoc.domain.Projet;
import groupeB2.ProjetPoc.domain.Temps;
import groupeB2.ProjetPoc.domain.User;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Service
public class AdminImpl implements AdminService{

	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ProjetRepository projetRepository;
	
	@Override
	@Transactional
	public Manager changeUserToManager(Long id) {
		User user=userRepository.getOne(id);
		String nom=user.getNom();
		String prenom=user.getPrenom();
		String password=user.getPassword();
		String login=user.getLogin();
		userRepository.deleteById(id);
		Manager manager=new Manager(nom,prenom,password,login);
		managerRepository.save(manager);
		return manager;
	}

	@Override
	@Transactional
	public Collection<Admin> findAllAdmin() {

		return this.adminRepository.findAll();
	}

	@Override
	@Transactional
	public User changeManager(Long id1, Long id2) {
		User user=userRepository.getOne(id1);
		Manager manager=managerRepository.getOne(id2);
		user.setManager(manager);
		Set<Projet> projets=new HashSet<>();
		user.setProjets(projets);
		Set<Temps> tempss=new HashSet<>();
		user.setTempss(tempss);
		userRepository.save(user);

		return null;
	}

	@Override
	public Admin changeUserToAdmin(Long id) {
		User user=userRepository.getOne(id);
		String nom=user.getNom();
		String prenom=user.getPrenom();
		String password=user.getPassword();
		String login=user.getLogin();
		userRepository.deleteById(id);
		Admin admin=new Admin(nom,prenom,password,login);
		adminRepository.save(admin);
		return admin;
	}

	@Override
	public Admin changeManagerToAdmin(Long id) {
		Manager manager=managerRepository.getOne(id);
		String nom=manager.getNom();
		String prenom=manager.getPrenom();
		String password=manager.getPassword();
		String login=manager.getLogin();
		
		manager.getUsers().forEach(user->user.setManager(null)); 
		manager.getProjets().forEach(projet->projetRepository.delete(projet));
		managerRepository.deleteById(id);
		Admin admin=new Admin(nom,prenom,password,login);
		adminRepository.save(admin);
		return admin;
	}

	

}
