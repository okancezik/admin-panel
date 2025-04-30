package com.okancezik.core.dto.category;

import com.okancezik.core.dto.product.ProductResponseDto;

import java.util.List;
import java.util.UUID;

public record CategoryUpdateRequestDto(
		UUID id,
		String name,
		String description,
		List<ProductResponseDto> productList
) {
}
