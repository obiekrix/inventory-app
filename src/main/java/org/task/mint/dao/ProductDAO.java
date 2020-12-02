package org.task.mint.dao;

import org.task.mint.entity.Product;

import java.util.List;


public interface ProductDAO {
	
	List<Product> getProducts();

	void saveProduct(Product theProduct);

	void updateProduct(Product theProduct);
	
	Product getProduct(int theId);

	void deleteProduct(int theId);

}
