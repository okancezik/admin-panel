package com.okancezik.service;

import com.okancezik.core.dto.category.CategoryCreateRequest;
import com.okancezik.core.dto.category.CategoryResponse;
import com.okancezik.core.dto.category.CategoryUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
	void save(CategoryCreateRequest request);

	boolean update(CategoryUpdateRequest request);

	void delete(UUID id);

	CategoryResponse findById(UUID id);

	List<CategoryResponse> findAll();
}
