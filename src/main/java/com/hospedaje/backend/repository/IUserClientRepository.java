/**
 * 
 */
package com.hospedaje.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospedaje.backend.model.UserAdministrator;
import com.hospedaje.backend.model.UserClient;

/**
 * @author rafael
 *
 */
@Repository
public interface IUserClientRepository extends JpaRepository<UserClient, Long>{

	@Query("from UserClient u where u.email = :email")
	public UserClient findByNickname(@Param("email") String email);
	
	@Query("from UserClient u where u.id = :id")
	public UserClient findByID(@Param(value = "id") Long id);
	
}
