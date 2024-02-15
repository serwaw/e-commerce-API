import java.util.ArrayList;

import org.example.Main;
import org.example.Product;
import org.example.ProductCostController;
import org.example.ProductRepository;
import org.example.ProductService;
import org.json.JSONObject;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;

public class IntegrationTest {

    @Test
    public void eCommerceApiIT() {
        try (ConfigurableApplicationContext context = new SpringApplicationBuilder()
            .sources(Main.class)
            .profiles("local").run(
                "--server.port=8081"
            )) {

            JSONObject json = new JSONObject();
            ProductService productService = context.getBean(ProductService.class);
            ProductCostController productCostController = context.getBean(ProductCostController.class);

            ProductRepository products = ProductRepository.getInstance();
            ArrayList<String> ids = new ArrayList<>(products.getAllProducts().stream().map(Product::id).toList());
            int totalCost = productService.findTotalCost(ids);
            String makeJson = String.valueOf(json.put("price", totalCost));
            ResponseEntity<Object> costJson = productCostController.findTotalCost(ids);

            assertThat(costJson).isEqualTo(ResponseEntity.ok(makeJson));
    } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
