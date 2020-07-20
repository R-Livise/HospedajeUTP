/**
 * 
 */
package com.hospedaje.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospedaje.backend.model.Reservation;

/**
 * @author rafael
 *
 */
@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long>{

	@Query("from Reservation r where r.id = :id")
	public Reservation findByID(@Param(value = "id") Long id);
}
