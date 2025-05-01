package com.okancezik.service.impl;

import com.okancezik.core.dto.product.ProductCreateRequest;
import com.okancezik.core.dto.product.ProductResponse;
import com.okancezik.core.dto.product.ProductUpdateRequest;
import com.okancezik.repository.data.ProductRepository;
import com.okancezik.repository.entity.Category;
import com.okancezik.service.CategoryService;
import com.okancezik.service.ProductService;
import com.okancezik.service.util.MappingProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;
	private final CategoryService   categoryService;

	@Override
	public void save(ProductCreateRequest request) {
		var categoryResponse = categoryService.findById(request.categoryId());
		if (categoryResponse == null) {
			throw new IllegalArgumentException("Category not found");
		}
		var category = Category.builder()
				.id(categoryResponse.id())
				.name(categoryResponse.name())
				.description(categoryResponse.description())
				.build();
		var product = MappingProduct.toProduct(request, category);
		productRepository.save(product);
	}

	@Override
	public void update(ProductUpdateRequest request) {
		var existingProduct = productRepository.findById(request.id())
				.orElseThrow(() -> new RuntimeException("Product not found"));
		existingProduct.setName(request.name());
		existingProduct.setDescription(request.description());
		existingProduct.setPrice(request.price());
		existingProduct.setStock(request.stock());
		productRepository.save(existingProduct);
	}

	@Override
	public void delete(UUID id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<ProductResponse> findAll() {
		var products = productRepository.findAll();
		return products.stream().map(MappingProduct::toProductResponse).toList();
	}
}
