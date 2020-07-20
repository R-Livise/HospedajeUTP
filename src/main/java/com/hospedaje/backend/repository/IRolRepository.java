/**
 * 
 */
package com.hospedaje.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospedaje.backend.model.Rol;

/**
 * @author rafael
 *
 */
@Repository
public interface IRolRepository extends JpaRepository<Rol, Long>{

	@Query("from Rol p where p.id = :id")
	public Rol findByID(@Param(value = "id") Long id);
}
