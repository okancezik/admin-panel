package com.okancezik.service;

import com.okancezik.core.dto.category.CategoryCreateRequestDto;
import com.okancezik.core.dto.category.CategoryResponseDto;
import com.okancezik.core.dto.category.CategoryUpdateRequestDto;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
	void save(CategoryCreateRequestDto request);
	void update(CategoryUpdateRequestDto request);
	void delete(CategoryUpdateRequestDto request);
	CategoryResponseDto findById(UUID id);
	List<CategoryResponseDto> findAll();

}
