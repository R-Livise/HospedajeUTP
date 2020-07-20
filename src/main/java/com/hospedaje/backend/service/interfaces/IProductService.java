/**
 * 
 */
package com.hospedaje.backend.service.interfaces;

import java.util.List;

import com.hospedaje.backend.model.Product;

/**
 * @author rafael
 *
 */
public interface IProductService {

	public List<Product> findAll();

	public Product findById(Long id);

	public void create(Product product);

	public void update(Product product);

	public void deleteById(Long id);
}
