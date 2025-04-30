package com.okancezik.service.impl;

import com.okancezik.core.dto.customer.CustomerCreateRequest;
import com.okancezik.core.dto.customer.CustomerResponse;
import com.okancezik.core.dto.customer.CustomerUpdateRequest;
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
		var customer = MappingCustomer.toCustomer(request);
		customerRepository.save(customer);
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
	public void delete(UUID id) {
		Optional<Customer> existCustomer = customerRepository.findById(id);
		existCustomer.ifPresent(customerRepository::delete);
	}
}
