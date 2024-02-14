package org.example;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import jakarta.ws.rs.Consumes;

@RestController
@RequestMapping("")
public class ProductCostController {
    private final ProductService productService;

    public ProductCostController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/checkout")
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> findTotalCost(@RequestBody ArrayList<String> productIds){
        double totalCosts = productService.findTotalCost(productIds);

        return ResponseEntity.ok(Double.toString(totalCosts));
    }
}