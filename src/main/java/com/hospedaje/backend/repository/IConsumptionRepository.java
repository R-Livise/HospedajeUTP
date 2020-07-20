/**
 * 
 */
package com.hospedaje.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospedaje.backend.model.Consumption;

/**
 * @author rafael
 *
 */
@Repository
public interface IConsumptionRepository extends JpaRepository<Consumption, Long>{

	@Query("from Consumption c where c.id = :id")
	public Consumption findByID(@Param(value = "id") Long id);
}
