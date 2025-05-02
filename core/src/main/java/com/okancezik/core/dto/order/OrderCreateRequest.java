package com.okancezik.core.dto.order;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record OrderCreateRequest(
		@NotNull(message = "Customer ID is required")
		UUID customerId,
		@NotEmpty(message = "Order items are required")
		@Size(min = 1, message = "At least one order item is required")
		List<OrderItemCreateRequest> orderItems
) {
}
