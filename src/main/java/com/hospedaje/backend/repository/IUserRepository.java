/**
 * 
 */
package com.hospedaje.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospedaje.backend.model.UserHotel;

/**
 * @author rafael
 *
 */
@Repository
public interface IUserRepository extends JpaRepository<UserHotel, Long>{

	@Query("from UserHotel uh where uh.email = :email")
	public UserHotel findByNickname(@Param("email") String email);
	
	@Query("from UserHotel uh where uh.id = :id")
	public UserHotel findByID(@Param(value = "id") Long id);
}
