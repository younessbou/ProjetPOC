package TimeRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import groupeB2.ProjetPoc.domain.Temps;

public interface TempsRepository extends JpaRepository<Temps, Long> {

}