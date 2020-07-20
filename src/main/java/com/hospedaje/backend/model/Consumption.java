/**
 * 
 */
package com.hospedaje.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author rafael
 *
 */
@Entity
@Table(name = "consumption")
public class Consumption {

	public Consumption() {
	}

	@Id
	@Column(name = "id_consumption")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name = "n_product")
	public int nProduct;
	@Column(name = "subTotal", precision = 2)
	public Double subTotal;

	@ManyToOne
	@JoinColumn(name="id_product")
	public Product product;
	
	@ManyToOne
	@JoinColumn(name="id_payment")
	public Payment payment;
	
}