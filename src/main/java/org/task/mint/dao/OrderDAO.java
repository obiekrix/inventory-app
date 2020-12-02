package org.task.mint.dao;

import org.task.mint.entity.Order;

import java.util.List;


public interface OrderDAO {
	
	List<Order> getOrders();

	void saveOrder(Order theOrder);

	void updateOrder(Order theOrder);
	
	Order getOrder(int theId);

	void deleteOrder(int theId);

}
