/**
 * 
 */
package com.hospedaje.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospedaje.backend.model.UserAdministrator;
import com.hospedaje.backend.model.UserAgencia;
import com.hospedaje.backend.model.UserClient;

/**
 * @author rafael
 *
 */
@Repository
public interface IUserAgenciaRepository extends JpaRepository<UserAgencia, Long>{

	@Query("from UserAgencia u where u.email = :email")
	public UserAgencia findByNickname(@Param("email") String email);
	
	@Query("from UserAgencia u where u.id = :id")
	public UserAgencia findByID(@Param(value = "id") Long id);
	
}
