package com.okancezik.core.dto.customer;

import java.util.UUID;

public record CustomerUpdateRequest(
		UUID id,
		String firstname,
		String lastname,
		String email,
		String phone,
		String address
) {
}
