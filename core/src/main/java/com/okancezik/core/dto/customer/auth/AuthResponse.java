package com.okancezik.core.dto.customer.auth;

import com.okancezik.core.dto.customer.CustomerResponse;
import lombok.Builder;

@Builder
public record AuthResponse(
		CustomerResponse customer,
		String message
) {
}
