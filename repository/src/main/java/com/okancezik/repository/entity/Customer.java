package com.okancezik.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private UUID id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String address;
}
