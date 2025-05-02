package com.okancezik.service;

import com.okancezik.core.dto.order.OrderCreateRequest;
import com.okancezik.core.dto.order.OrderResponse;

import java.util.List;

public interface OrderService {
	void save(OrderCreateRequest request);
	List<OrderResponse> findAll();
	/*Order findById(UUID id);
	void deleteById(UUID id);*/
}
