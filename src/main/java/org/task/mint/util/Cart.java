package org.task.mint.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.task.mint.model.Customer;

import java.util.List;

/**
 * @author Christian
 */
@Getter
@AllArgsConstructor
public class Cart {

    private List<OrderedItem> listOfOrderedItems;
    private int processingAdminId;
    private Customer customer;

    public Cart() {

    }

    @Override
    public String toString() {
        return "Cart [listOfOrderedItems=" + listOfOrderedItems +
                ", customer=" + customer +
                ", processingAdminId=" + processingAdminId + "]";
    }


}
