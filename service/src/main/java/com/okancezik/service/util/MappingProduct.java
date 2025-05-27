package com.okancezik.service.util;

import com.okancezik.core.dto.product.ProductCreateRequest;
import com.okancezik.core.dto.product.ProductResponse;
import com.okancezik.repository.entity.Category;
import com.okancezik.repository.entity.Product;

import java.util.UUID;

public class MappingProduct {
	private MappingProduct(){
		throw new IllegalStateException("Utility class");
	}

	public static Product toProduct(ProductCreateRequest request, Category category){
		return Product.builder()
				.id(UUID.randomUUID())
				.name(request.name())
				.description(request.description())
				.price(request.price())
				.stock(request.stock())
				.image(request.image())
				.category(category)
				.build();
	}

	public static ProductResponse toProductResponse(Product product){
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.stock(product.getStock())
				.image(product.getImage())
				.categoryId(product.getCategory().getId())
				.categoryName(product.getCategory().getName())
				.build();
	}
}
