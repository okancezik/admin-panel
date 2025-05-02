package com.okancezik.api;

import com.okancezik.core.dto.order.OrderCreateRequest;
import com.okancezik.core.dto.order.OrderResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface OrderApi {
	@PostMapping
	ResponseEntity<String> save(
			@RequestBody @Valid OrderCreateRequest request);

	@GetMapping
	ResponseEntity<List<OrderResponse>> findAll();

	@DeleteMapping("/{id}")
	ResponseEntity<OrderResponse> delete(
			@PathVariable UUID id
	);
}
