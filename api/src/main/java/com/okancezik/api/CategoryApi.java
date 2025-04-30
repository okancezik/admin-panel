package com.okancezik.api;

import com.okancezik.core.dto.category.CategoryCreateRequest;
import com.okancezik.core.dto.category.CategoryResponse;
import com.okancezik.core.dto.category.CategoryUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface CategoryApi {

	@PostMapping
	ResponseEntity<CategoryResponse> save(
			@RequestBody @Valid CategoryCreateRequest request);

	@PutMapping
	ResponseEntity<CategoryResponse> update(
			@RequestBody @Valid CategoryUpdateRequest request);

	@GetMapping
	ResponseEntity<List<CategoryResponse>> getAll();

	@DeleteMapping("/{id}")
	ResponseEntity<CategoryResponse> delete(
			@PathVariable UUID id);
}
