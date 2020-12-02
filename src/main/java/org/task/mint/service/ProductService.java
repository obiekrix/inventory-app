package org.task.mint.service;

import org.task.mint.entity.Product;
import org.task.mint.model.ProductModel;

import java.util.List;

/**
 * @author Christian
 *
 */
public interface ProductService {
	
	List<Product> getProducts();

	void saveProduct(ProductModel model);

	void updateProduct(Product theProduct);

	Product getProduct(int theId);

	void deleteProduct(int theId);
}
