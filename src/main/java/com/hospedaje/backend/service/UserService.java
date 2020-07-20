/**
 * 
 */
package com.hospedaje.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospedaje.backend.model.UserHotel;
import com.hospedaje.backend.repository.IUserRepository;
import com.hospedaje.backend.service.interfaces.IUserService;

/**
 * @author rafael
 *
 */
@Service
@Transactional
public class UserService implements IUserService{

	@Autowired
	public IUserRepository _userRepository;

	@Override
	public List<UserHotel> findAll() {
		
		return _userRepository.findAll();
	}

	@Override
	public UserHotel findById(Long id) {

		return _userRepository.findByID(id);
	}

	@Override
	public void create(UserHotel userHotel) {
		
		_userRepository.save(userHotel);
		
	}

	@Override
	public void update(UserHotel userHotel) {
		
		_userRepository.save(userHotel);
	}

	@Override
	public void deleteById(Long id) {
		
		UserHotel userHotel = _userRepository.findByID(id);
		_userRepository.delete(userHotel);
	}
	
	@Override
	public UserHotel findByNickname(String nickname) {
		
		return _userRepository.findByNickname(nickname);
	}
}
