/**
 * 
 */
package com.hospedaje.backend.service.interfaces;

import java.util.List;

import com.hospedaje.backend.model.Rol;

/**
 * @author rafael
 *
 */
public interface IRolService {

	public List<Rol> findAll();

	public Rol findById(Long id);

	public void create(Rol rol);

	public void update(Rol rol);

	public void deleteById(Long id);
}
