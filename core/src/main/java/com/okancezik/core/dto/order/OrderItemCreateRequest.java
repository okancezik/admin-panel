package com.okancezik.core.dto.order;

import lombok.Builder;

import java.util.UUID;

@Builder
public record OrderItemCreateRequest(
		UUID productId,
		int quantity
) {
}

