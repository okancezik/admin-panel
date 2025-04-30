package com.okancezik.api.impl;

import com.okancezik.api.CategoryApi;
import com.okancezik.core.dto.category.CategoryCreateRequestDto;
import com.okancezik.core.dto.category.CategoryResponseDto;
import com.okancezik.core.dto.category.CategoryUpdateRequestDto;
import com.okancezik.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController implements CategoryApi {
	private final CategoryService categoryService;

	@Override
	public ResponseEntity<CategoryResponseDto> save(CategoryCreateRequestDto request) {
		categoryService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Override
	public ResponseEntity<CategoryResponseDto> update(CategoryUpdateRequestDto request) {
		categoryService.update(request);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	public ResponseEntity<List<CategoryResponseDto>> getAll() {
		return ResponseEntity.ok(categoryService.findAll());
	}

	@Override
	public ResponseEntity<CategoryResponseDto> delete(UUID id){
		categoryService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
