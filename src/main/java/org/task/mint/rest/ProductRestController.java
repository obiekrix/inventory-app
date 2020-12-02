/**
 * 
 */
package org.task.mint.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task.mint.entity.Product;
import org.task.mint.exception.AppException;
import org.task.mint.exception.ResourceNotFoundException;
import org.task.mint.model.ProductModel;
import org.task.mint.service.ProductService;

import java.util.List;

/**
 * @author Christian
 *
 */
@RestController
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@GetMapping("/all")
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id) {

		Product product = productService.getProduct(id);

		if (product == null) {
			throw new ResourceNotFoundException("Product", "id", id);
		}

		return product;
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addProduct(@RequestBody ProductModel model) {

		if (!model.isInValidState()) {
			throw new AppException("Model is not in a valid state. Ensure none of the field is null");
		}

		productService.saveProduct(model);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody Product theProduct) {

		Product updatedProduct = theProduct;
		updatedProduct.setId(id);

		productService.updateProduct(updatedProduct);

		return ResponseEntity.ok().build();
	}
}
