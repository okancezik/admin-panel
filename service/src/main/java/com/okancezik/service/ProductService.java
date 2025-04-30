package com.okancezik.service;

import com.okancezik.core.dto.product.ProductCreateRequest;
import com.okancezik.core.dto.product.ProductResponseDto;
import com.okancezik.core.dto.product.ProductUpdateRequest;

import java.util.List;

public interface ProductService {
	void save(ProductCreateRequest request);
	void update(ProductUpdateRequest request);
	void delete(ProductUpdateRequest request);
	List<ProductResponseDto> findAll();
}
