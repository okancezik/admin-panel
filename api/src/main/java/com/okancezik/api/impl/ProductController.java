package com.okancezik.api.impl;

import com.okancezik.api.ProductApi;
import com.okancezik.core.dto.product.ProductCreateRequest;
import com.okancezik.core.dto.product.ProductResponseDto;
import com.okancezik.core.dto.product.ProductUpdateRequest;
import com.okancezik.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController implements ProductApi {
	private final ProductService productService;

	@Override
	public ResponseEntity<ProductResponseDto> save(ProductCreateRequest request) {
		productService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Override
	public ResponseEntity<ProductResponseDto> update(ProductUpdateRequest request) {
		productService.update(request);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	public ResponseEntity<ProductResponseDto> delete(ProductUpdateRequest request) {
		productService.delete(request);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	public ResponseEntity<List<ProductResponseDto>> getAll() {
		return ResponseEntity.ok(productService.findAll());
	}
}
