package org.task.mint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.task.mint.dao.AdminDAO;
import org.task.mint.dao.BrandDAO;
import org.task.mint.dao.CategoryDAO;
import org.task.mint.dao.ProductDAO;
import org.task.mint.entity.Admin;
import org.task.mint.entity.Brand;
import org.task.mint.entity.Category;
import org.task.mint.entity.Product;
import org.task.mint.model.ProductModel;

import java.util.List;

/**
 * @author Christian
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO stockDAO;

	@Autowired
	private AdminDAO adminDAO;

	@Autowired
	private BrandDAO brandDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	@Transactional
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return stockDAO.getProducts();
	}

	@Override
	@Transactional
	public void saveProduct(ProductModel model) {
		// TODO Auto-generated method stub

		// get the admin
		Admin admin = adminDAO.getAdmin(model.getAdminId());

		// get the brand
		Brand brand = brandDAO.getBrand(model.getBrandId());

		// get the category
		Category category = categoryDAO.getCategory(model.getCategoryId());

		// build up the stock
		Product stock = new Product();

		stock.setAdmin(admin);
		stock.setBrand(brand);
		stock.setCategory(category);
		stock.setCostPrice(model.getCostPrice());
		stock.setCreationDate(model.getCreationDate());
		stock.setDescription(model.getDescription());
		stock.setEnabled(model.getEnabled());
		stock.setFeatures(model.getFeatures());
		stock.setLastOrder(model.getLastOrder());
		stock.setOrders(model.getOrders());
		stock.setRemainingQuantity(model.getRemainingQuantity());
		stock.setSellingPrice(model.getSellingPrice());

		// save the stock
		stockDAO.saveProduct(stock);
	}

	@Override
	@Transactional
	public void updateProduct(Product theProduct) {
		// TODO Auto-generated method stub

		stockDAO.updateProduct(theProduct);
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		// TODO Auto-generated method stub

		return stockDAO.getProduct(theId);
	}

	@Override
	public void deleteProduct(int theId) {
		// TODO Auto-generated method stub

	}

}
