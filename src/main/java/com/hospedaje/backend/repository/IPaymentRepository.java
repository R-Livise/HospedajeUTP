/**
 * 
 */
package com.hospedaje.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospedaje.backend.model.Payment;

/**
 * @author rafael
 *
 */
@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long>{

	@Query("from Payment p where p.id = :id")
	public Payment findByID(@Param(value = "id") Long id);
}
