/**
 * 
 */
package com.hospedaje.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospedaje.backend.model.Product;

/**
 * @author rafael
 *
 */
@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{

	@Query("from Product p where p.id = :id")
	public Product findByID(@Param(value = "id") Long id);
}
