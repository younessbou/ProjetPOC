package groupeB2.ProjetPoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import groupeB2.ProjetPoc.domain.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

}
