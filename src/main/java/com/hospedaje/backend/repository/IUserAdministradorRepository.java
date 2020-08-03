/**
 * 
 */
package com.hospedaje.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospedaje.backend.model.UserAdministrator;

/**
 * @author rafael
 *
 */
@Repository
public interface IUserAdministradorRepository extends JpaRepository<UserAdministrator, Long>{

	@Query("from UserAdministrator u where u.email = :email")
	public UserAdministrator findByNickname(@Param("email") String email);
	
	@Query("from UserAdministrator u where u.id = :id")
	public UserAdministrator findByID(@Param(value = "id") Long id);
	
}
