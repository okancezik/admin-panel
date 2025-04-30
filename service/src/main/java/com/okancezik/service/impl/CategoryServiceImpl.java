package com.okancezik.service.impl;

import com.okancezik.core.dto.category.CategoryCreateRequest;
import com.okancezik.core.dto.category.CategoryResponse;
import com.okancezik.core.dto.category.CategoryUpdateRequest;
import com.okancezik.repository.data.CategoryRepository;
import com.okancezik.service.CategoryService;
import com.okancezik.service.util.MappingCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;

	@Override
	public void save(CategoryCreateRequest request) {
		var category = MappingCategory.toCategory(request);
		categoryRepository.save(category);
	}

	@Override
	public boolean update(CategoryUpdateRequest request) {
		return categoryRepository.findById(request.id())
				.map(category -> {
					category.setName(request.name());
					category.setDescription(request.description());
					categoryRepository.save(category);
					return true;
				})
				.orElse(false);
	}

	@Override
	public void delete(UUID id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public CategoryResponse findById(UUID id) {
		return categoryRepository.findById(id)
				.map(MappingCategory::toCategoryResponse)
				.orElse(null);
	}

	@Override
	public List<CategoryResponse> findAll() {
		var categories = categoryRepository.findAll();
		return categories.stream()
				.map(MappingCategory::toCategoryResponse).toList();
	}
}
