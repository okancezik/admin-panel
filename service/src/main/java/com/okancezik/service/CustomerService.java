package com.okancezik.service;

import com.okancezik.core.dto.customer.CustomerCreateRequest;
import com.okancezik.core.dto.customer.CustomerResponse;
import com.okancezik.core.dto.customer.CustomerUpdateRequest;
import com.okancezik.repository.entity.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
	void save(CustomerCreateRequest request);

	boolean update(CustomerUpdateRequest request);

	void delete(UUID id);

	List<CustomerResponse> findAll();

	Optional<Customer> findById(UUID uuid);
}
