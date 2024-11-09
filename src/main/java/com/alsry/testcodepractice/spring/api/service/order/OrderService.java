package com.alsry.testcodepractice.spring.api.service.order;

import com.alsry.testcodepractice.spring.api.controller.order.request.OrderCreateRequest;
import com.alsry.testcodepractice.spring.api.service.order.response.OrderResponse;
import com.alsry.testcodepractice.spring.domain.order.Order;
import com.alsry.testcodepractice.spring.domain.order.OrderRepository;
import com.alsry.testcodepractice.spring.domain.product.Product;
import com.alsry.testcodepractice.spring.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderResponse createOrder(OrderCreateRequest orderCreateRequest, LocalDateTime registeredDateTime) {
        List<String> productNumbers = orderCreateRequest.getProductNumbers();
        //Product
        List<Product> products = findProductsBy(productNumbers);

        //order
        Order order = Order.create(products, registeredDateTime);
        Order savedOrder = orderRepository.save(order);

        return OrderResponse.of(savedOrder);
    }

    private List<Product> findProductsBy(List<String> productNumbers) {
        List<Product> products = productRepository.findAllByProductNumberIn(productNumbers);

        Map<String, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getProductNumber, product -> product));

        List<Product> orderingProducts = productNumbers.stream()
                .map(productMap::get)
                .toList();

        return orderingProducts;
    }
}
