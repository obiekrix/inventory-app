package org.task.mint.service;

import org.task.mint.entity.Brand;
import org.task.mint.model.BrandModel;

import java.util.List;

/**
 * @author Christian
 *
 */
public interface BrandService {
	
	List<Brand> getBrands();

	void saveBrand(BrandModel model);

	void updateBrand(Brand theBrand);

	Brand getBrand(int theId);

	void deleteBrand(int theId);
}
