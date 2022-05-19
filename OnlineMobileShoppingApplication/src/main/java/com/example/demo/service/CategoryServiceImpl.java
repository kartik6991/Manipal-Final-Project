package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.exception.CategoryException;
import com.example.demo.repository.ICategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private ICategoryRepository categoryRepo;

	@Override
	public List<Category> getAllCategory() {
		return categoryRepo.findAll();
	}

	@Override
	public Category addCategory(Category category) throws CategoryException {
		Optional<Category> newCategory = this.categoryRepo.findById(category.getCategoryId());
		if (newCategory.isPresent())
			throw new CategoryException("Already category added");
		return this.categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return this.categoryRepo.save(category);
	}

	@Override
	public String deleteCategory(Integer id) {
		this.categoryRepo.deleteById(id);
		return "Category deleted successfully";
	}

}
