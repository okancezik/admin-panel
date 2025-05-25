package com.okancezik.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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
	private String password;
	private String againPassword;
	private String email;
	private String phone;
	private String address;

	@Column(columnDefinition = "boolean default false")
	private boolean isSubscribed = false;

	@Column(columnDefinition = "boolean default true")
	private boolean isPrivacyPolicy = true;
}
