/**
 * 
 */
package com.hospedaje.backend.service.interfaces;

import java.util.List;

import com.hospedaje.backend.model.UserAdministrator;

/**
 * @author rafael
 *
 */
public interface IUserAdministradorService {

	public List<UserAdministrator> findAll();
	
	UserAdministrator findById(Long id);

	public void create(UserAdministrator userHotel);

	public void update(UserAdministrator userHotel);

	public void deleteById(Long id);
	
	public UserAdministrator findByNickname(String nickname);
}
