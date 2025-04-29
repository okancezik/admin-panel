package com.okancezik.core.dto.category;

import java.util.UUID;

public record CategoryUpdateRequestDto(
		UUID id,
		String name,
		String description
) {
}
