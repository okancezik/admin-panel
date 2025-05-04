package com.okancezik.service;

import com.okancezik.core.dto.category.CategoryCreateRequest;
import com.okancezik.core.dto.category.CategoryResponse;
import com.okancezik.core.dto.category.CategoryUpdateRequest;
import com.okancezik.repository.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
	void save(CategoryCreateRequest request);

	boolean update(CategoryUpdateRequest request);

	void delete(UUID id);

	CategoryResponse findById(UUID id);

	Optional<Category> findCategoryById(UUID id);

	List<CategoryResponse> findAll();
}
