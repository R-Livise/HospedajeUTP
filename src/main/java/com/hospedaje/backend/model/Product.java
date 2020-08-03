/**
 * 
 */
package com.hospedaje.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rafael
 *
 */
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

	public Product() {
	}

	@Id
	@Column(name = "id_product")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name = "name", length = 50)
	public String name;
	@Column(name = "price", precision = 2)
	public Double price;

}