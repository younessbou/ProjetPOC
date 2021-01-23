package groupeB2.ProjetPoc.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupeB2.ProjetPoc.Service.ProjetService;
import groupeB2.ProjetPoc.dao.ProjetRepository;
import groupeB2.ProjetPoc.domain.Projet;

@Service
public class ProjetIml implements ProjetService {
	
	@Autowired
	private ProjetRepository projetRepository;

	@Override
	public List<Projet> findAllProjets() {
		// TODO Auto-generated method stub
		return this.projetRepository.findAll();
	}

}
