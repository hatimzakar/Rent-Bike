package org.pfa.dao;

import org.pfa.entities.Abonnement;
import org.pfa.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<Payment,Integer>{
	

	@Query("SELECT u FROM Payment u WHERE u.reference= :reference")
	Payment findByReference(@Param("reference") String referecne);

}
