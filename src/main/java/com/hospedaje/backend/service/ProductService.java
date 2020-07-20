/**
 * 
 */
package com.hospedaje.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospedaje.backend.model.Product;
import com.hospedaje.backend.repository.IProductRepository;
import com.hospedaje.backend.service.interfaces.IProductService;

/**
 * @author rafael
 *
 */
@Service
@Transactional
public class ProductService implements IProductService{

	@Autowired
	public IProductRepository _productRepository;

	@Override
	public List<Product> findAll() {
		
		return _productRepository.findAll();
	}

	@Override
	public Product findById(Long id) {

		return _productRepository.findByID(id);
	}

	@Override
	public void create(Product product) {
		
		_productRepository.save(product);
		
	}

	@Override
	public void update(Product product) {
		
		_productRepository.save(product);
		
	}

	@Override
	public void deleteById(Long id) {
		
		Product product = _productRepository.findByID(id);
		_productRepository.delete(product);
		
	}
}
