package groupeB2.ProjetPoc.Impl;

import java.util.Collection;
import java.util.Set;

import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groupeB2.ProjetPoc.Service.AdminService;
import groupeB2.ProjetPoc.dao.AdminRepository;
import groupeB2.ProjetPoc.dao.ManagerRepository;
import groupeB2.ProjetPoc.dao.UserRepository;
import groupeB2.ProjetPoc.domain.Admin;
import groupeB2.ProjetPoc.domain.Manager;
import groupeB2.ProjetPoc.domain.Projet;
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
		manager.addUser(user);
		userRepository.save(user);
		managerRepository.save(manager);
		return user;
	}

	

}
