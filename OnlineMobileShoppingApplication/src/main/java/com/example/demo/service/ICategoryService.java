package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Category;
import com.example.demo.exception.CategoryException;

public interface ICategoryService {
	List<Category> getAllCategory();

	Category addCategory(Category category) throws CategoryException;

	Category updateCategory(Category category);

	String deleteCategory(Integer id);
}
