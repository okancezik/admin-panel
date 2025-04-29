package com.okancezik.api;

import com.okancezik.core.dto.category.CategoryCreateRequestDto;
import com.okancezik.core.dto.category.CategoryResponseDto;
import com.okancezik.core.dto.category.CategoryUpdateRequestDto;
import com.okancezik.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryApi {
	private final CategoryService categoryService;

	@PostMapping
	public ResponseEntity<CategoryResponseDto> save(
			@RequestBody CategoryCreateRequestDto request) {
		categoryService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	public ResponseEntity<CategoryResponseDto> update(
			@RequestBody CategoryUpdateRequestDto request) {
		categoryService.update(request);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping
	public ResponseEntity<List<CategoryResponseDto>> getAll() {
		return ResponseEntity.ok(categoryService.findAll());
	}

	@DeleteMapping
	public ResponseEntity<CategoryResponseDto> delete(
			@RequestBody CategoryUpdateRequestDto request){
		categoryService.delete(request);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
