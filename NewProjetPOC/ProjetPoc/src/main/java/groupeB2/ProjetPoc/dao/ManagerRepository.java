package groupeB2.ProjetPoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import groupeB2.ProjetPoc.domain.Manager;


public interface ManagerRepository extends JpaRepository<Manager,Long>  {

}