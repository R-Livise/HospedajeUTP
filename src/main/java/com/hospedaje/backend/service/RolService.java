/**
 * 
 */
package com.hospedaje.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospedaje.backend.model.Rol;
import com.hospedaje.backend.repository.IRolRepository;
import com.hospedaje.backend.service.interfaces.IRolService;

/**
 * @author rafael
 *
 */
@Service
@Transactional
public class RolService implements IRolService{

	@Autowired
	IRolRepository _rolRepository;
	
	@Override
	public List<Rol> findAll() {
		
		return _rolRepository.findAll();
	}

	@Override
	public Rol findById(Long id) {
		
		return _rolRepository.findByID(id);
	}

	@Override
	public void create(Rol rol) {
		
		_rolRepository.save(rol);
	}

	@Override
	public void update(Rol rol) {
		
		_rolRepository.save(rol);
	}

	@Override
	public void deleteById(Long id) {
		
		Rol rol = _rolRepository.findByID(id);
		_rolRepository.delete(rol);
	}

}
