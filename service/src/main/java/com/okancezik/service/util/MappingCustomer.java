package com.okancezik.service.util;

import com.okancezik.core.dto.customer.CustomerCreateRequest;
import com.okancezik.core.dto.customer.CustomerResponse;
import com.okancezik.repository.entity.Customer;

import java.util.UUID;

public class MappingCustomer {
	private MappingCustomer() {
		throw new IllegalStateException("Utility class");
	}

	public static CustomerResponse toCustomerResponse(Customer customer) {
		return CustomerResponse.builder()
				.id(customer.getId())
				.firstname(customer.getFirstname())
				.lastname(customer.getLastname())
				.email(customer.getEmail())
				.phone(customer.getPhone())
				.address(customer.getAddress())
				.build();
	}

	public static Customer toCustomer(CustomerCreateRequest request) {
		return Customer.builder()
				.id(UUID.randomUUID())
				.firstname(request.firstname())
				.lastname(request.lastname())
				.email(request.email())
				.phone(request.phone())
				.address(request.address())
				.build();
	}
}
