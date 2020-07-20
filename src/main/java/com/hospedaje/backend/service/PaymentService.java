/**
 * 
 */
package com.hospedaje.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospedaje.backend.model.Payment;
import com.hospedaje.backend.repository.IPaymentRepository;
import com.hospedaje.backend.service.interfaces.IPaymentService;

/**
 * @author rafael
 *
 */
@Service
@Transactional
public class PaymentService implements IPaymentService{

	@Autowired
	public IPaymentRepository _paymentRepository;

	@Override
	public List<Payment> findAll() {
		
		return _paymentRepository.findAll();
	}

	@Override
	public Payment findById(Long id) {

		return _paymentRepository.findByID(id);
	}

	@Override
	public void create(Payment payment) {
		
		_paymentRepository.save(payment);
		
	}

	@Override
	public void update(Payment payment) {
		
		_paymentRepository.save(payment);
		
	}

	@Override
	public void deleteById(Long id) {
		
		Payment payment = _paymentRepository.findByID(id);
		_paymentRepository.delete(payment);
		
	}
}
