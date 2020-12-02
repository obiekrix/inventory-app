package org.task.mint.dao;

import org.task.mint.entity.Brand;

import java.util.List;


public interface BrandDAO {
	
	List<Brand> getBrands();

	void saveBrand(Brand theBrand);

	void updateBrand(Brand theBrand);
	
	Brand getBrand(int theId);

	void deleteBrand(int theId);

}
