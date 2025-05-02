package com.okancezik.service.impl;

import com.okancezik.core.dto.order.OrderCreateRequest;
import com.okancezik.core.dto.order.OrderItemResponse;
import com.okancezik.core.dto.order.OrderResponse;
import com.okancezik.repository.data.OrderRepository;
import com.okancezik.repository.entity.Customer;
import com.okancezik.repository.entity.Order;
import com.okancezik.repository.entity.OrderItem;
import com.okancezik.repository.entity.Product;
import com.okancezik.service.CustomerService;
import com.okancezik.service.OrderService;
import com.okancezik.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	private final OrderRepository repository;
	private final ProductService  productService;
	private final CustomerService customerService;

	@Override
	public void save(OrderCreateRequest request) {
		Customer customer = customerService.findById(request.customerId())
				.orElseThrow(() -> new RuntimeException("Customer not found"));
		Order order = Order.builder()
				.id(UUID.randomUUID())
				.customer(customer)
				.build();
		List<OrderItem> orderItems = request.orderItems().stream()
				.map(itemRequest -> {
					Product product = productService.findById(itemRequest.productId())
							.orElseThrow(() -> new RuntimeException("Product not found"));
					if (product.getStock() < itemRequest.quantity()) {
						throw new RuntimeException("Product out of stock: " + product.getName());
					}
					return OrderItem.builder()
							.id(UUID.randomUUID())
							.order(order)
							.product(product)
							.quantity(itemRequest.quantity())
							.build();
				})
				.toList();
		order.setOrderItems(orderItems);
		repository.save(order);
	}

	@Override
	public List<OrderResponse> findAll() {
		List<Order> orders = repository.findAll();
		return orders.stream().map(order -> {
			Customer customer = order.getCustomer();
			List<OrderItem> items = order.getOrderItems();
			var orderItems = items.stream().map(i ->
					OrderItemResponse.builder()
							.productName(i.getProduct().getName())
							.quantity(i.getQuantity())
							.productId(i.getProduct().getId())
							.price(i.getProduct().getPrice())
							.build()).toList();
			var totalAmount = items.stream()
					.mapToDouble(item ->
							item.getProduct().getPrice() * item.getQuantity())
					.sum();
			return OrderResponse.builder()
					.orderId(order.getId())
					.customerEmail(customer.getEmail())
					.customerName(customer.getFirstname() + ' ' + customer.getLastname())
					.totalAmount(totalAmount)
					.items(orderItems)
					.build();
		}).toList();
	}

	@Override
	public void delete(UUID id) {
		repository.deleteById(id);
	}
}
