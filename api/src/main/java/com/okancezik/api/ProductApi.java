package com.okancezik.api;

import com.okancezik.core.dto.product.ProductCreateRequest;
import com.okancezik.core.dto.product.ProductResponse;
import com.okancezik.core.dto.product.ProductUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface ProductApi {
	@PostMapping
	ResponseEntity<ProductResponse> save(
			@RequestBody @Valid ProductCreateRequest request);

	@PutMapping
	ResponseEntity<ProductResponse> update(
			@RequestBody @Valid ProductUpdateRequest request
	);

	@DeleteMapping("/{id}")
	ResponseEntity<ProductResponse> delete(
			@PathVariable UUID id
	);

	@GetMapping
	ResponseEntity<List<ProductResponse>> getAll();
}
