/**
 * 
 */
package com.hospedaje.backend.service.interfaces;

import java.util.List;

import com.hospedaje.backend.model.UserAgencia;

/**
 * @author rafael
 *
 */
public interface IUserAgenciaService {

	public List<UserAgencia> findAll();
	
	UserAgencia findById(Long id);

	public void create(UserAgencia userHotel);

	public void update(UserAgencia userHotel);

	public void deleteById(Long id);
	
	public UserAgencia findByNickname(String nickname);
}
