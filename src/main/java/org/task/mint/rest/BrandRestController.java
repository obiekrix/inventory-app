/**
 * 
 */
package org.task.mint.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task.mint.entity.Brand;
import org.task.mint.exception.AppException;
import org.task.mint.exception.ResourceNotFoundException;
import org.task.mint.model.BrandModel;
import org.task.mint.service.BrandService;

import java.util.List;

/**
 * @author Christian
 *
 */
@RestController
@RequestMapping("/brand")
public class BrandRestController {

	@Autowired
	private BrandService brandService;

	@GetMapping("/all")
	public List<Brand> getBrands() {
		return brandService.getBrands();
	}

	@GetMapping("/{id}")
	public Brand getBrand(@PathVariable int id) {
		
		Brand brand = brandService.getBrand(id);
		
		if(brand == null) {
			throw new ResourceNotFoundException("Product", "id", id);
		}
		
		return brandService.getBrand(id);
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addBrand(@RequestBody BrandModel model) {
		
		if(!model.isInValidState()) {
			throw new AppException("Model is not in a valid state. Ensure none of the field is null");
		}
		
		brandService.saveBrand(model);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateBrand(@PathVariable int id, @RequestBody Brand theBrand) {

		Brand updatedBrand = theBrand;
		updatedBrand.setId(id);
		
		brandService.updateBrand(updatedBrand);

		return ResponseEntity.ok().build();
	}
}
