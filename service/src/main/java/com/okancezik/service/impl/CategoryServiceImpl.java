package com.okancezik.service.impl;

import com.okancezik.core.dto.category.CategoryCreateRequestDto;
import com.okancezik.core.dto.category.CategoryResponseDto;
import com.okancezik.core.dto.category.CategoryUpdateRequestDto;
import com.okancezik.core.dto.product.ProductResponseDto;
import com.okancezik.repository.data.CategoryRepository;
import com.okancezik.repository.entity.Category;
import com.okancezik.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;

	@Override
	public void save(CategoryCreateRequestDto request) {
		var category = Category.builder()
				.id(UUID.randomUUID())
				.name(request.name())
				.description(request.description())
				.productList(List.of())
				.build();
		categoryRepository.save(category);
	}

	@Override
	public void update(CategoryUpdateRequestDto request) {
		var category = Category.builder()
				.id(request.id())
				.name(request.name())
				.description(request.description())
				.productList(List.of())//TO DO impl
				.build();
		categoryRepository.save(category);
	}

	@Override
	public void delete(CategoryCreateRequestDto request) {
		var category = Category.builder()
				.id(UUID.randomUUID())
				.name(request.name())
				.description(request.description())
				.productList(List.of())
				.build();
		categoryRepository.delete(category);
	}

	@Override
	public CategoryResponseDto findById(UUID id) {
		return null;
	}

	@Override
	public List<CategoryResponseDto> findAll() {
		var categories = categoryRepository.findAll();
		return categories.stream().map(category ->
			CategoryResponseDto.builder()
					.id(category.getId())
					.name(category.getName())
					.description(category.getDescription())
					.productList(
							category.getProductList().stream().map(product ->
									ProductResponseDto.builder()
											.id(product.getId())
											.name(product.getName())
											.description(product.getDescription())
											.stock(product.getStock())
											.price(product.getPrice())
											.build()
							).toList()
					)
					.build()
		).toList();
	}
}
