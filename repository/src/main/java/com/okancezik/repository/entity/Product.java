package com.okancezik.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	private UUID        id;
	private String      name;
	private String      description;
	private double      price;
	private int         stock;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
	private Category    category;
}
