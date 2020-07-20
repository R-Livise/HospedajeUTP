/**
 * 
 */
package com.hospedaje.backend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author rafael
 *
 */
@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@Column(name = "id_payment")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name = "total")
	public Double total;
	@Column(name = "is_payment")
	public boolean isPayment;
	
	@OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
	public Set<Consumption> consumption;
	
	@OneToOne
	@JoinColumn(name = "id_reservation")
	public Reservation reservation;

}