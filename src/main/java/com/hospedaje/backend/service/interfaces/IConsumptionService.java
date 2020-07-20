/**
 * 
 */
package com.hospedaje.backend.service.interfaces;

import java.util.List;

import com.hospedaje.backend.model.Consumption;

/**
 * @author rafael
 *
 */
public interface IConsumptionService {

	public List<Consumption> findAll();
	
	public Consumption findById(Long id);
	
	public void create(Consumption consumption);
	
	public void update(Consumption consumption);
	
	public void deleteById(Long id);
}
