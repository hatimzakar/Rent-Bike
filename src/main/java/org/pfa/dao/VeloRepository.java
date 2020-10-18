package org.pfa.dao;

import org.pfa.entities.Velo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VeloRepository extends JpaRepository<Velo,Integer>{
	
	@Query("SELECT u FROM Velo u WHERE u.Matricule= :matricule")
	Velo findByMatricule(@Param("matricule") String matricule);
	

}
