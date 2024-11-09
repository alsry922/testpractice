package com.alsry.testcodepractice.spring.api.service.product;

import com.alsry.testcodepractice.spring.api.service.product.response.ProductResponse;
import com.alsry.testcodepractice.spring.domain.product.Product;
import com.alsry.testcodepractice.spring.domain.product.ProductRepository;
import com.alsry.testcodepractice.spring.domain.product.ProductSellingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> getSellingProducts() {
        List<Product> products = productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());
        List<ProductResponse> productResponse = products.stream().map(ProductResponse::of).toList();
        return productResponse;
    }
}
