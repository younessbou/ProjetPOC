package groupeB2.ProjetPoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import groupeB2.ProjetPoc.domain.Projet;

public interface ProjetRepository extends JpaRepository<Projet,Long> {

}