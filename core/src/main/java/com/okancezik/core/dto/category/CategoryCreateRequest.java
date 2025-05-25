package com.okancezik.core.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CategoryCreateRequest(
		@NotBlank(message = "Name is required field")
		String name,
		@NotBlank(message = "Description is required field")
		String description,
		@NotBlank(message = "Category's image is required field")
		String image
) {
}
