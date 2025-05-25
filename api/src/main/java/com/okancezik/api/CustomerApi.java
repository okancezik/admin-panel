package com.okancezik.api;

import com.okancezik.core.dto.customer.CustomerCreateRequest;
import com.okancezik.core.dto.customer.CustomerLoginRequest;
import com.okancezik.core.dto.customer.CustomerResponse;
import com.okancezik.core.dto.customer.CustomerUpdateRequest;
import com.okancezik.core.dto.customer.auth.AuthResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

public interface CustomerApi {
	@PostMapping
	ResponseEntity<CustomerResponse> save(
			@RequestBody @Valid CustomerCreateRequest request);

	@PutMapping
	ResponseEntity<CustomerResponse> update(
			@RequestBody @Valid CustomerUpdateRequest request
	);

	@DeleteMapping("/{id}")
	ResponseEntity<CustomerUpdateRequest> delete(
			@PathVariable UUID id
	);

	@GetMapping
	ResponseEntity<List<CustomerResponse>> getAll();

	@PostMapping("/login")
	ResponseEntity<AuthResponse> login(
		@RequestBody @Valid CustomerLoginRequest request
	);
}
