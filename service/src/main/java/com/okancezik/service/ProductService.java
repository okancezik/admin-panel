package com.okancezik.service;

import com.okancezik.core.dto.product.ProductCreateRequest;
import com.okancezik.core.dto.product.ProductResponse;
import com.okancezik.core.dto.product.ProductUpdateRequest;
import com.okancezik.repository.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
	void save(ProductCreateRequest request);

	void update(ProductUpdateRequest request);

	void delete(UUID id);

	List<ProductResponse> findAll();

	List<Product> findByIds(List<UUID> ids);

	Optional<Product> findById(UUID id);
}
