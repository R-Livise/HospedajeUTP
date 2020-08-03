/**
 * 
 */
package com.hospedaje.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hospedaje.backend.model.UserAdministrator;
import com.hospedaje.backend.model.UserAgencia;
import com.hospedaje.backend.model.UserClient;
import com.hospedaje.backend.model.UserHotel;
import com.hospedaje.backend.repository.IUserAdministradorRepository;
import com.hospedaje.backend.repository.IUserAgenciaRepository;
import com.hospedaje.backend.repository.IUserClientRepository;
import com.hospedaje.backend.service.interfaces.IUserService;

/**
 * @author rafael
 *
 */
@Service("Agencia")
@Transactional
public class UserAgenciaService implements IUserService{

	@Autowired
	public IUserAgenciaRepository _userRepository;

	@Override
	public List<UserHotel> findAll() {
		
		return (List<UserHotel>)(List<?>)_userRepository.findAll();
	}

	@Override
	public UserHotel findById(Long id) {

		return _userRepository.findByID(id);
	}

	@Override
	public void create(UserHotel userHotel) {
		
		_userRepository.save((UserAgencia)userHotel);
		
	}

	@Override
	public void update(UserHotel userHotel) {
		
		_userRepository.save((UserAgencia)userHotel);
	}

	@Override
	public void deleteById(Long id) {
		
		UserAgencia userHotel = _userRepository.findByID(id);
		_userRepository.delete(userHotel);
	}
	
	@Override
	public UserHotel findByNickname(String nickname) {
		
		return _userRepository.findByNickname(nickname);
	}
}
