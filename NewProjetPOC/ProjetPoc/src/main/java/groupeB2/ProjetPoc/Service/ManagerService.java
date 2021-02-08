package groupeB2.ProjetPoc.Service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import groupeB2.ProjetPoc.domain.Manager;
import groupeB2.ProjetPoc.domain.Projet;
import groupeB2.ProjetPoc.domain.Temps;
import groupeB2.ProjetPoc.domain.User;

public interface ManagerService {

	public List<Manager> findAllManagers();

	public Manager Add_user(Long id, @Valid User user);

	public Manager Add_projet(Long id,Projet projet);

	public Set<Temps> findAllTime(Long id);

}
