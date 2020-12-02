package org.task.mint.dao;

import org.task.mint.entity.OrderedProduct;

import java.util.List;

public interface OrderedProductDAO {
	
	List<OrderedProduct> getOrderedProducts();

	void saveOrderedProduct(OrderedProduct theOrderedProduct);

	void updateOrderedProduct(OrderedProduct theOrderedProduct);
	
	OrderedProduct getOrderedProduct(int theId);

	void deleteOrderedProduct(int theId);

}
