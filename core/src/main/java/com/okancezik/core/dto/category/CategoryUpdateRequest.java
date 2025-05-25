package com.okancezik.core.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CategoryUpdateRequest(
		@NotNull(message = "ID must not be null")
		UUID id,
		@NotBlank(message = "Name must not be blank")
		@Size(max = 100, message = "Name must not exceed 100 characters")
		String name,
		@NotBlank(message = "Description must not be blank")
		@Size(max = 255, message = "Description must not exceed 255 characters")
		String description,
		@NotBlank(message = "Category's image is required field")
		String image
) {
}
