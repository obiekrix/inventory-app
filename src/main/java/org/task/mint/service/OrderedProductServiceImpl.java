package org.task.mint.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.task.mint.dao.OrderedProductDAO;
import org.task.mint.entity.Admin;
import org.task.mint.entity.Order;
import org.task.mint.entity.OrderedProduct;
import org.task.mint.entity.Product;
import org.task.mint.exception.BadRequestException;
import org.task.mint.util.Cart;
import org.task.mint.util.KafkaSender;
import org.task.mint.util.OrderedItem;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Christian
 */
@Service
public class OrderedProductServiceImpl implements OrderedProductService {

    @Autowired
    private OrderedProductDAO orderedProductDAO;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private KafkaSender sender;

    @Override
    @Transactional
    public List<OrderedProduct> getOrderedProducts() {
        // TODO Auto-generated method stub
        return orderedProductDAO.getOrderedProducts();
    }

    @Override
    @Transactional
    public void saveOrderedProduct(Cart cart) {
        // TODO Auto-generated method stub

        // get the time of this order
        Date timeOfOrder = new GregorianCalendar().getTime();

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Order order = new Order();

        order.setTimeOfSale(timeOfOrder);
        order.setAdmin(currentSession.get(Admin.class, cart.getProcessingAdminId()));
        order.setCustomerNames(cart.getCustomer().getNames());
        order.setCustomerPhoneNo(cart.getCustomer().getPhoneNo());

        for (OrderedItem orderedItem : cart.getListOfOrderedItems()) {
            Product product = currentSession.get(Product.class, orderedItem.getProductId());

            product.setLastOrder(timeOfOrder);
            int remainingQuantity = product.getRemainingQuantity() - orderedItem.getQuantity();

            if (remainingQuantity <= 0) {
                throw new BadRequestException("Sorry! There isn't enough " + product.getDescription() + " to fulfill the request. We have just " + product.getRemainingQuantity() + " left in stock");
            }

            product.setRemainingQuantity(remainingQuantity);

            currentSession.update(product);

            OrderedProduct orderedProduct = new OrderedProduct();

            orderedProduct.getPk().setOrder(order);
            orderedProduct.getPk().setProduct(product);
            orderedProduct.setQuantity(orderedItem.getQuantity());
            orderedProduct.setSoldPrice(orderedItem.getSoldPrice());

            order.getOrderedProducts().add(orderedProduct);
        }

        currentSession.save(order);

        sender.sendData(cart);
    }

    @Override
    @Transactional
    public void updateOrderedProduct(OrderedProduct theOrderedProduct) {
        // TODO Auto-generated method stub

        orderedProductDAO.updateOrderedProduct(theOrderedProduct);
    }

    @Override
    @Transactional
    public OrderedProduct getOrderedProduct(int theId) {
        // TODO Auto-generated method stub

        return orderedProductDAO.getOrderedProduct(theId);
    }

    @Override
    public void deleteOrderedProduct(int theId) {
        // TODO Auto-generated method stub

    }

}
