import org.example.ProductCostController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;

@WebMvcTest(ProductCostController.class)
public class ProductCostControllerTest {

    @Before
    public void setUp() {
    }

    @Test
    public void should_returnOk_whenApplicationIsRunning() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ArrayList<String> productIds = new ArrayList<>();
        productIds.add("001");
        productIds.add("001");
        ResponseEntity<String> response = testRestTemplate.
            postForEntity("http://localhost:8080/checkout", productIds, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}