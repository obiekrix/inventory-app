/**
 * 
 */
package org.task.mint.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task.mint.entity.Category;
import org.task.mint.exception.AppException;
import org.task.mint.exception.ResourceNotFoundException;
import org.task.mint.model.CategoryModel;
import org.task.mint.service.CategoryService;

import java.util.List;

/**
 * @author Christian
 *
 */
@RestController
@RequestMapping("/category")
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/all")
	public List<Category> getCategories() {
		return categoryService.getCategories();
	}

	@GetMapping("/{id}")
	public Category getCategory(@PathVariable int id) {

		Category category = categoryService.getCategory(id);
		
		if(category == null) {
			throw new ResourceNotFoundException("Category", "id", id);
		}
		
		return category;
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addCategory(@RequestBody CategoryModel model) {

		if(!model.isInValidState()) {
			throw new AppException("Model is not in a valid state. Ensure none of the field is null");
		}
		
		categoryService.saveCategory(model);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateCategory(@PathVariable int id, @RequestBody Category theCategory) {

		Category updatedCategory = theCategory;
		updatedCategory.setId(id);
		
		categoryService.updateCategory(updatedCategory);

		return ResponseEntity.ok().build();
	}
}
