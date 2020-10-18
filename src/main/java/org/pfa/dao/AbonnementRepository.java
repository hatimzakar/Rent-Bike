package org.pfa.dao;

import org.pfa.entities.Abonnement;
import org.pfa.entities.Velo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AbonnementRepository extends JpaRepository<Abonnement,Integer>{

	@Query("SELECT u FROM Abonnement u WHERE u.pin= :pin")
	Abonnement findByPin(@Param("pin") long pin);
	

}
