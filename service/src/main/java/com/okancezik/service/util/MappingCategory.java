package com.okancezik.service.util;

import com.okancezik.core.dto.category.CategoryCreateRequest;
import com.okancezik.core.dto.category.CategoryResponse;
import com.okancezik.repository.entity.Category;

import java.util.List;
import java.util.UUID;

public class MappingCategory {
	private MappingCategory() {
		throw new IllegalStateException("Utility class");
	}

	public static Category toCategory(CategoryCreateRequest request) {
		return Category.builder()
				.id(UUID.randomUUID())
				.name(request.name())
				.description(request.description())
				.productList(List.of())
				.build();
	}

	public static CategoryResponse toCategoryResponse(Category category) {
		return CategoryResponse.builder()
				.id(category.getId())
				.name(category.getName())
				.description(category.getDescription())
				.productList(category.getProductList().stream()
						.map(MappingProduct::toProductResponse).toList())
				.build();
	}
}
