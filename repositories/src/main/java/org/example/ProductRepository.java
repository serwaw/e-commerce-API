package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProductRepository {
    private static final ProductRepository instance = new ProductRepository();
    private final Product[] products;
    private ProductRepository() {
        products = new Product[]{
            new Product("001", "Rolex", 100),
            new Product("002", "Michael Kors", 80),
            new Product("003", "Swatch", 50),
            new Product("004", "Casio", 30)
        };
    }

    public static ProductRepository getInstance() {
        return instance;
    }

    public List<Product> getAllProducts() {
        return Arrays.asList(products);
    }


    public Product getProductById(String id) {
        for (Product product : products) {
            if (Objects.equals(product.id(), id)) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        products[products.length] = product;
    }

}