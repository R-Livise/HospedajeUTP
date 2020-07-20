/**
 * 
 */
package com.hospedaje.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospedaje.backend.model.Reservation;
import com.hospedaje.backend.repository.IReservationRepository;
import com.hospedaje.backend.service.interfaces.IReservationService;

/**
 * @author rafael
 *
 */
@Service
@Transactional
public class ReservationService implements IReservationService{

	@Autowired
	public IReservationRepository _reservationRepository;

	@Override
	public List<Reservation> findAll() {
		
		return _reservationRepository.findAll();
	}

	@Override
	public Reservation findById(Long id) {

		return _reservationRepository.findByID(id);
	}

	@Override
	public void create(Reservation reservation) {
		
		_reservationRepository.save(reservation);
		
	}

	@Override
	public void update(Reservation reservation) {
		
		_reservationRepository.save(reservation);
		
	}

	@Override
	public void deleteById(Long id) {
		
		Reservation reservation = _reservationRepository.findByID(id);
		_reservationRepository.delete(reservation);
		
	}
}
