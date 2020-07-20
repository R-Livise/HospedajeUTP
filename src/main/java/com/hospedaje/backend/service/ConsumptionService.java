/**
 * 
 */
package com.hospedaje.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospedaje.backend.model.Consumption;
import com.hospedaje.backend.repository.IConsumptionRepository;
import com.hospedaje.backend.service.interfaces.IConsumptionService;

/**
 * @author rafael
 *
 */
@Service
@Transactional
public class ConsumptionService implements IConsumptionService{

	@Autowired
	public IConsumptionRepository _consumptionRepository;

	@Override
	public List<Consumption> findAll() {
		
		return _consumptionRepository.findAll();
	}

	@Override
	public Consumption findById(Long id) {

		return _consumptionRepository.findByID(id);
	}

	@Override
	public void create(Consumption consumption) {
		
		_consumptionRepository.save(consumption);
		
	}

	@Override
	public void update(Consumption consumption) {
		
		_consumptionRepository.save(consumption);
		
	}

	@Override
	public void deleteById(Long id) {
		
		Consumption consumption = _consumptionRepository.findByID(id);
		_consumptionRepository.delete(consumption);
		
	}
}
