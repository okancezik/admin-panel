package com.okancezik.core.dto.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CustomerUpdateRequest(
		@NotNull(message = "ID must not be null")
		UUID id,
		@NotBlank(message = "Firstname is required field")
		String firstname,
		@NotBlank(message = "Lastname is required field")
		String lastname,
		@NotBlank(message = "Email is required field")
		String email,
		@NotBlank(message = "Phone is required field")
		String phone,
		@NotBlank(message = "Address is required field")
		String address
) {
}
