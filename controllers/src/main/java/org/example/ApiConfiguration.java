package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {
    @Bean
    public ProductCostController productCostController(ProductService productService) {
        return new ProductCostController(productService);
    }
}
