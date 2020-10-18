package org.pfa.dao;

import org.pfa.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamationRepository extends JpaRepository<Reclamation,Integer>{

	
	
	/*
	 * @Query("select u FROM Reclamation u where u.client = :idClient")
	 * List<Reclamation> findAllById(@Param("idClient") Integer idClient);
	 * 
	 * 
	 * 
	 * @Query(value="SELECT * FROM Reclamation u WHERE u.id_client = 1", nativeQuery
	 * = true) List<Reclamation> findetoileById();
	 * 
	 */

	


}
