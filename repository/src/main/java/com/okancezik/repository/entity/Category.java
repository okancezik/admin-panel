package com.okancezik.repository.entity;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	private UUID id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "category")
	private List<Product> productList;
}
