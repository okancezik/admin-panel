package com.okancezik.service;

import com.okancezik.core.dto.order.OrderCreateRequest;
import com.okancezik.core.dto.order.OrderResponse;
import com.okancezik.core.dto.order.OrderUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface OrderService {
	void save(OrderCreateRequest request);

	List<OrderResponse> findAll();

	void delete(UUID id);

	void update(OrderUpdateRequest request);

	List<OrderResponse> findByCustomerId(UUID id);
}
