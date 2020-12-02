package org.task.mint.service;

import org.task.mint.entity.OrderedProduct;
import org.task.mint.util.Cart;

import java.util.List;

/**
 * @author Christian
 *
 */
public interface OrderedProductService {
	
	List<OrderedProduct> getOrderedProducts();

	void saveOrderedProduct(Cart cart);

	void updateOrderedProduct(OrderedProduct theOrderedProduct);

	OrderedProduct getOrderedProduct(int theId);

	void deleteOrderedProduct(int theId);
}
