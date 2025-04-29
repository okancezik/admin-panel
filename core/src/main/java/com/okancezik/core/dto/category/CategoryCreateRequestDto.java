package com.okancezik.core.dto.category;

import lombok.Builder;

@Builder
public record CategoryCreateRequestDto(
		String name,
		String description
) {
}
