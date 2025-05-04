package com.okancezik.core.dto.order;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record OrderResponse(
		UUID id,
		UUID customerId,
		String customerName,
		String customerEmail,
		List<OrderItemResponse> items,
		Double totalAmount
) {
}
