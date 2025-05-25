package com.okancezik.core.dto.customer;

import jakarta.validation.constraints.NotBlank;

public record CustomerLoginRequest(
		@NotBlank(message = "Email is required field")
		String email,
		@NotBlank(message = "Password is required field")
		String password
) {
}
