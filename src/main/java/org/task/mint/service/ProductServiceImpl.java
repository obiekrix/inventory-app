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
	private ProductDAO productDAO;

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
		return productDAO.getProducts();
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

		// build up the product
		Product product = new Product();

		product.setAdmin(admin);
		product.setBrand(brand);
		product.setCategory(category);
		product.setCostPrice(model.getCostPrice());
		product.setCreationDate(model.getCreationDate());
		product.setDescription(model.getDescription());
		product.setEnabled(model.getEnabled());
		product.setFeatures(model.getFeatures());
		product.setLastOrder(model.getLastOrder());
		product.setOrders(model.getOrders());
		product.setRemainingQuantity(model.getRemainingQuantity());
		product.setSellingPrice(model.getSellingPrice());

		// save the product
		productDAO.saveProduct(product);
	}

	@Override
	@Transactional
	public void updateProduct(Product theProduct) {
		// TODO Auto-generated method stub

		productDAO.updateProduct(theProduct);
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		// TODO Auto-generated method stub

		return productDAO.getProduct(theId);
	}

	@Override
	public void deleteProduct(int theId) {
		// TODO Auto-generated method stub

	}

}
