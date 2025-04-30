package com.okancezik.core.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CategoryCreateRequestDto(
		@NotBlank(message = "Name is required field")
		String name,
		@NotBlank(message = "Description is required field")
		String description
) {
}
