package com.okancezik.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@Id
	private UUID id;
	private String name;
	private String        description;
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Product> productList;
}
