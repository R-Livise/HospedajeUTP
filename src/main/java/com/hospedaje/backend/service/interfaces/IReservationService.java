/**
 * 
 */
package com.hospedaje.backend.service.interfaces;

import java.util.List;

import com.hospedaje.backend.model.Reservation;

/**
 * @author rafael
 *
 */
public interface IReservationService {

	public List<Reservation> findAll();

	public Reservation findById(Long id);

	public void create(Reservation reservation);

	public void update(Reservation reservation);

	public void deleteById(Long id);
}
