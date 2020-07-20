/**
 * 
 */
package com.hospedaje.backend.service.interfaces;

import java.util.List;

import com.hospedaje.backend.model.UserHotel;

/**
 * @author rafael
 *
 */
public interface IUserService {

	public List<UserHotel> findAll();

	public UserHotel findById(Long id);

	public void create(UserHotel userHotel);

	public void update(UserHotel userHotel);

	public void deleteById(Long id);
	
	public UserHotel findByNickname(String nickname);
}
