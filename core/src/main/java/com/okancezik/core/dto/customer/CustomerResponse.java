package com.okancezik.core.dto.customer;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CustomerResponse(
		UUID id,
		String firstname,
		String lastname,
		String email,
		String phone,
		String address
) {
}
