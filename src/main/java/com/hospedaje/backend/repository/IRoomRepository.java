/**
 * 
 */
package com.hospedaje.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospedaje.backend.model.Room;

/**
 * @author rafael
 *
 */
@Repository
public interface IRoomRepository extends JpaRepository<Room, Long>{

	@Query("from Room r where r.id = :id")
	public Room findByID(@Param(value = "id") Long id);
}
