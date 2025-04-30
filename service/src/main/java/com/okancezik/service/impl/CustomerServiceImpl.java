package com.okancezik.service.impl;

import com.okancezik.core.dto.customer.CustomerCreateRequest;
import com.okancezik.core.dto.customer.CustomerResponse;
import com.okancezik.core.dto.customer.CustomerUpdateRequest;
import com.okancezik.repository.data.CustomerRepository;
import com.okancezik.repository.entity.Customer;
import com.okancezik.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository customerRepository;
	@Override
	public void save(CustomerCreateRequest request) {
		var customer = Customer.builder()
				.id(UUID.randomUUID())
				.firstname(request.firstname())
				.lastname(request.lastname())
				.email(request.email())
				.phone(request.phone())
				.address(request.address())
				.build();
		customerRepository.save(customer);
	}

	@Override
	public void update(CustomerUpdateRequest request) {
	}

	@Override
	public List<CustomerResponse> findAll() {
		var customers = customerRepository.findAll();
		return customers.stream().map(c -> CustomerResponse.builder()
				.id(c.getId())
				.firstname(c.getFirstname())
				.lastname(c.getLastname())
				.email(c.getEmail())
				.phone(c.getPhone())
				.address(c.getAddress())
				.build()).toList();
	}

	@Override
	public void delete(UUID id) {
		Optional<Customer> existCustomer = customerRepository.findById(id);
		existCustomer.ifPresent(customerRepository::delete);
	}
}
