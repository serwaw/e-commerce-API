package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService() {
        this.productRepository = ProductRepository.getInstance();

        initializeProductRepository();
    }

    private void initializeProductRepository() {
        if (productRepository.getAllProducts().isEmpty()) {
            productRepository.addProduct(new Product("001", "Rolex", 100));
            productRepository.addProduct(new Product("002", "Michael Kors", 80));
            productRepository.addProduct(new Product("003", "Swatch", 50));
            productRepository.addProduct(new Product("004", "Casio", 30));
        }
    }

    public double findTotalCost(ArrayList<String> productIds) {
        double totalCost = 0.0;
        Map<String, Integer> productCounts = new HashMap<>();

        for (String productId : productIds) {
            productCounts.put(productId, productCounts.getOrDefault(productId, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : productCounts.entrySet()) {
            String productId = entry.getKey();
            int quantity = entry.getValue();

            Product product = productRepository.getProductById(productId);
            if (product != null) {
                if (Objects.equals(productId, "001")) {
                    int discountedQuantity = quantity / 3 * 2 + quantity % 3;
                    totalCost += discountedQuantity * product.price();
                } else if (Objects.equals(productId, "002") && quantity >= 2) {
                    int discountedQuantity = (quantity / 2) + (quantity % 2);
                    totalCost += discountedQuantity * product.price() * 0.5;
                } else {
                    totalCost += quantity * product.price();
                }
            }
        }

        return totalCost;
    }
}