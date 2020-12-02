package org.task.mint.util;

import java.util.List;

/**
 * @author Christian
 *
 */
public class Cart{
	
	private List<OrderedItem> listOfOrderedItems;
	private int processingAdminId;

	public Cart() {
		
	}
	
	/**
	 * @param listOfOrderedItems
	 * @param processingAdminId
	 */
	public Cart(List<OrderedItem> listOfOrderedItems, int processingAdminId) {
		this.listOfOrderedItems = listOfOrderedItems;
		this.processingAdminId = processingAdminId;
	}

	public List<OrderedItem> getListOfOrderedItems() {
		return listOfOrderedItems;
	}

	public int getProcessingAdminId() {
		return processingAdminId;
	}

	@Override
	public String toString() {
		return "Cart [listOfOrderedItems=" + listOfOrderedItems + ", processingAdminId=" + processingAdminId + "]";
	}
	
	

}
