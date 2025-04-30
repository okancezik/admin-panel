package com.okancezik.api;

import com.okancezik.core.dto.product.ProductCreateRequest;
import com.okancezik.core.dto.product.ProductResponseDto;
import com.okancezik.core.dto.product.ProductUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ProductApi {
	@PostMapping
	ResponseEntity<ProductResponseDto> save(
			@RequestBody ProductCreateRequest request);

	@PutMapping
	ResponseEntity<ProductResponseDto> update(
			@RequestBody ProductUpdateRequest request
	);

	@DeleteMapping
	ResponseEntity<ProductResponseDto> delete(
			@RequestBody ProductUpdateRequest request
	);

	@GetMapping
	ResponseEntity<List<ProductResponseDto>> getAll();
}
