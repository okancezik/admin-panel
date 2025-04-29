package com.okancezik.core.dto.category;

import com.okancezik.core.dto.product.ProductResponseDto;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record CategoryResponseDto (
		UUID id,
		String name,
		String description,
		List<ProductResponseDto> productList
){
}
