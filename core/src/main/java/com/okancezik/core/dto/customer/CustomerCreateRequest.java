package com.okancezik.core.dto.customer;

import lombok.Builder;

@Builder
public record CustomerCreateRequest(
		String firstname,
		String lastname,
		String email,
		String phone,
		String address
) {
}
