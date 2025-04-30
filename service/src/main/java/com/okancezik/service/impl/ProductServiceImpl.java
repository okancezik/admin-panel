package com.okancezik.service.impl;

import com.okancezik.core.dto.product.ProductCreateRequest;
import com.okancezik.core.dto.product.ProductResponseDto;
import com.okancezik.core.dto.product.ProductUpdateRequest;
import com.okancezik.repository.data.ProductRepository;
import com.okancezik.repository.entity.Category;
import com.okancezik.repository.entity.Product;
import com.okancezik.service.CategoryService;
import com.okancezik.service.ProductService;
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
				.productList(categoryResponse.productList().stream().map(p -> Product.builder()
						.id(p.id())
						.name(p.name())
						.description(p.description())
						.stock(p.stock())
						.price(p.price())
						.build()).toList())
				.build();
		var product = Product.builder()
				.id(UUID.randomUUID())
				.name(request.name())
				.description(request.description())
				.price(request.price())
				.stock(request.stock())
				.category(category)
				.build();
		productRepository.save(product);
	}

	@Override
	public void update(ProductUpdateRequest request) {
		var existingProduct = productRepository.findById(request.id())
				.orElseThrow(() -> new RuntimeException("Product not found"));
		var categoryResponse = categoryService.findById(request.categoryId());
		if (categoryResponse == null) {
			throw new IllegalArgumentException("Category not found");
		}
		var category = Category.builder()
				.id(categoryResponse.id())
				.name(categoryResponse.name())
				.description(categoryResponse.description())
				.build();
		existingProduct.setName(request.name());
		existingProduct.setDescription(request.description());
		existingProduct.setPrice(request.price());
		existingProduct.setStock(request.stock());
		existingProduct.setCategory(category);
		productRepository.save(existingProduct);
	}

	@Override
	public void delete(UUID id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<ProductResponseDto> findAll() {
		var products = productRepository.findAll();
		return products.stream().map(product -> ProductResponseDto.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.stock(product.getStock())
				.build()).toList();
	}
}
