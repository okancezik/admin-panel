package com.okancezik.service.impl;

import com.okancezik.core.dto.customer.CustomerCreateRequest;
import com.okancezik.core.dto.customer.CustomerLoginRequest;
import com.okancezik.core.dto.customer.CustomerResponse;
import com.okancezik.core.dto.customer.CustomerUpdateRequest;
import com.okancezik.core.dto.customer.auth.AuthResponse;
import com.okancezik.repository.data.CustomerRepository;
import com.okancezik.repository.entity.Customer;
import com.okancezik.service.CustomerService;
import com.okancezik.service.util.MappingCustomer;
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
		if (request.password().equals(request.againPassword())) {
			Optional<Customer> optionalCustomer = customerRepository.findByEmail(request.email());
			if (optionalCustomer.isPresent()) {
				throw new IllegalArgumentException("Customer already exists");
			}
			var customer = MappingCustomer.toCustomer(request);
			customerRepository.save(customer);
		} else
			throw new IllegalArgumentException("Passwords don't match");
	}

	@Override
	public boolean update(CustomerUpdateRequest request) {
		return customerRepository.findById(request.id()).map(customer -> {
			customer.setFirstname(request.firstname());
			customer.setLastname(request.lastname());
			customer.setEmail(request.email());
			customer.setPhone(request.phone());
			customer.setAddress(request.address());
			customerRepository.save(customer);
			return true;
		}).orElse(false);
	}

	@Override
	public List<CustomerResponse> findAll() {
		return customerRepository.findAll().stream().map(
				MappingCustomer::toCustomerResponse
		).toList();
	}

	@Override
	public Optional<Customer> findById(UUID uuid) {
		return customerRepository.findById(uuid);
	}

	@Override
	public void delete(UUID id) {
		Optional<Customer> existCustomer = customerRepository.findById(id);
		existCustomer.ifPresent(customerRepository::delete);
	}

	@Override
	public AuthResponse login(CustomerLoginRequest request) {
		Optional<Customer> optionalCustomer = customerRepository.findByEmail(request.email());
		if (optionalCustomer.isPresent()) {
			var customer = optionalCustomer.get();
			if (customer.getPassword().equals(request.password())) {
				return AuthResponse.builder()
						.customer(MappingCustomer.toCustomerResponse(customer))
						.message("Login successful")
						.build();
			} else {
				return AuthResponse.builder()
						.customer(null)
						.message("Login fail because wrong password")
						.build();
			}
		}
		return AuthResponse.builder()
				.customer(null)
				.message("Not Found Customer")
				.build();
	}
}
