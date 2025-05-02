package com.okancezik.core.dto.order;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record OrderResponse(
		UUID orderId,
		UUID customerId,
		String customerName,
		String customerEmail,
		//LocalDate orderDate,
		List<OrderItemResponse> items,
		Double totalAmount
) {
}
