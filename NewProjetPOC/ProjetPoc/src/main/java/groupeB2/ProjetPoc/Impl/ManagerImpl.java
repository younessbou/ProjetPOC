package groupeB2.ProjetPoc.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupeB2.ProjetPoc.Service.ManagerService;
import groupeB2.ProjetPoc.dao.ManagerRepository;
import groupeB2.ProjetPoc.domain.Manager;

@Service
public class ManagerImpl implements ManagerService {

	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Override
	public List<Manager> findAllManagers() {
		// TODO Auto-generated method stub
		return this.managerRepository.findAll();
	}

}
