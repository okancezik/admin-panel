package com.okancezik.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	private UUID id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String address;
}
