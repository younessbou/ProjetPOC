package groupeB2.ProjetPoc.Service;

import java.util.Collection;

import org.springframework.stereotype.Service;


import groupeB2.ProjetPoc.domain.Manager;
import groupeB2.ProjetPoc.domain.User;
import groupeB2.ProjetPoc.domain.Admin;


public interface AdminService {

	Manager changeUserToManager(Long id);

	Collection<Admin> findAllAdmin();

	User changeManager(Long id1, Long id2);

	Admin changeUserToAdmin(Long id);

}
