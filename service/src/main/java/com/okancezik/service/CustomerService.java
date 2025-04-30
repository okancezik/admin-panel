package com.okancezik.service;

import com.okancezik.core.dto.customer.CustomerCreateRequest;
import com.okancezik.core.dto.customer.CustomerResponse;
import com.okancezik.core.dto.customer.CustomerUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
	void save(CustomerCreateRequest request);

	void update(CustomerUpdateRequest request);

	void delete(UUID id);

	List<CustomerResponse> findAll();
}
