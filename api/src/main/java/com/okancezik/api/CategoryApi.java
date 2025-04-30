package com.okancezik.api;

import com.okancezik.core.dto.category.CategoryCreateRequestDto;
import com.okancezik.core.dto.category.CategoryResponseDto;
import com.okancezik.core.dto.category.CategoryUpdateRequestDto;
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
	ResponseEntity<CategoryResponseDto> save(
			@RequestBody CategoryCreateRequestDto request);

	@PutMapping
	ResponseEntity<CategoryResponseDto> update(
			@RequestBody CategoryUpdateRequestDto request);

	@GetMapping
	ResponseEntity<List<CategoryResponseDto>> getAll();

	@DeleteMapping("/{id}")
	ResponseEntity<CategoryResponseDto> delete(
			@PathVariable UUID id);
}
