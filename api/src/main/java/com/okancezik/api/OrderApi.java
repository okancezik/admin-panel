package com.okancezik.api;

import com.okancezik.core.dto.order.OrderCreateRequest;
import com.okancezik.core.dto.order.OrderResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderApi {
	@PostMapping
	ResponseEntity<String> save(
			@RequestBody @Valid OrderCreateRequest request);

	@GetMapping
	ResponseEntity<List<OrderResponse>> findAll();
}
