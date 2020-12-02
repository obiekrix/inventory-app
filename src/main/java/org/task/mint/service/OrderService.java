package org.task.mint.service;

import org.task.mint.entity.Order;

import java.util.List;

/**
 * @author Christian
 *
 */
public interface OrderService {
	
	List<Order> getOrders();

	void saveOrder(Order theOrder);

	void updateOrder(Order theOrder);

	Order getOrder(int theId);

	void deleteOrder(int theId);
}
