package org.example;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;

@RestController
@RequestMapping("")
public class ProductCostController {
    private final ProductService productService;

    public ProductCostController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/checkout")
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findTotalCost(@RequestBody ArrayList<String> productIds) {
        JSONObject json = new JSONObject();
        int totalCost = productService.findTotalCost(productIds);
        String costJson = String.valueOf(json.put("price", totalCost));

        return ResponseEntity.ok(costJson);
    }
}