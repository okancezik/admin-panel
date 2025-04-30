package com.okancezik.core.dto.product;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ProductUpdateRequest(
		UUID id,
		String name,
		String description,
		double price,
		int stock,
		UUID categoryId
) {
}
