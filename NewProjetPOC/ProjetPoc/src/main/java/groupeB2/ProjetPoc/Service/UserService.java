package groupeB2.ProjetPoc.Service;
import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import groupeB2.ProjetPoc.domain.User;
@Service
public interface UserService {
	
	public List<User> findAllUsers();

	public Optional<User> findUserById(Long id);
}
