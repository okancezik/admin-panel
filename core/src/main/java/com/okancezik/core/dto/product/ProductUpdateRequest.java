package com.okancezik.core.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.util.UUID;

@Builder
public record ProductUpdateRequest(
		@NotNull(message = "ID must not be null")
		UUID id,
		@NotBlank(message = "Product name is required field")
		String name,
		@NotBlank(message = "Description is required field")
		String description,
		@NotBlank(message = "Image is required field")
		String image,
		@Positive(message = "Price must be a positive number")
		double price,
		@Min(value = 0, message = "Stock must be greater than or equal to 0")
		int stock,
		@NotNull(message = "ID must not be null")
		UUID categoryId
) {
}
