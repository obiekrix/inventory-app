/**
 * 
 */
package org.task.mint.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task.mint.entity.OrderedProduct;
import org.task.mint.service.OrderedProductService;
import org.task.mint.util.Cart;

import java.util.List;

/**
 * @author Christian
 *
 */
@RestController
@RequestMapping("/order")
public class OrderedProductRestController {

	@Autowired
	private OrderedProductService orderedProductService;

	@GetMapping("/all")
	public List<OrderedProduct> getOrderedProducts() {
		return orderedProductService.getOrderedProducts();
	}

	@GetMapping("/{id}")
	public OrderedProduct getOrderedProduct(@PathVariable int id) {
		return orderedProductService.getOrderedProduct(id);
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addOrderedProduct(@RequestBody Cart cart) {
		orderedProductService.saveOrderedProduct(cart);

		return ResponseEntity.ok().build();
	}

}
