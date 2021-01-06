package TimeRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import groupeB2.ProjetPoc.domain.User;

public interface UserRepository extends JpaRepository<User, Long>  {

}
