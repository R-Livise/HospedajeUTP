/**
 * 
 */
package com.hospedaje.backend.service.interfaces;

import java.util.List;

import com.hospedaje.backend.model.UserAdministrator;
import com.hospedaje.backend.model.UserClient;

/**
 * @author rafael
 *
 */
public interface IUserClientService {

	public List<UserClient> findAll();
	
	UserClient findById(Long id);

	public void create(UserClient userHotel);

	public void update(UserClient userHotel);

	public void deleteById(Long id);
	
	public UserClient findByNickname(String nickname);
}
