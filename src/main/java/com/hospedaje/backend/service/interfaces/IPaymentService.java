/**
 * 
 */
package com.hospedaje.backend.service.interfaces;

import java.util.List;

import com.hospedaje.backend.model.Payment;

/**
 * @author rafael
 *
 */
public interface IPaymentService {

	public List<Payment> findAll();

	public Payment findById(Long id);

	public void create(Payment payment);

	public void update(Payment payment);

	public void deleteById(Long id);
}
