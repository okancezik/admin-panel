package com.okancezik.core.dto.order;

import lombok.Builder;

import java.util.UUID;

@Builder
public record OrderItemResponse (
		UUID productId,
		String productName,
		Integer quantity,
		Double price
){
}
