package groupeB2.ProjetPoc.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import groupeB2.ProjetPoc.domain.Projet;

@Service
public interface ProjetService {
	
	public List<Projet> findAllProjets();

}
