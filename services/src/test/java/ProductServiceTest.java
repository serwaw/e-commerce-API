import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.example.ProductRepository;
import org.example.ProductService;
import org.junit.Before;
import org.junit.Test;

public class ProductServiceTest {

    private ProductService productService;

    @Before
    public void setUp() {
        productService = new ProductService();
    }

    @Test
    public void should_returnCorrectTotalcost_whenSendingAListWithIds() {
        ArrayList<String> ids = new ArrayList<>();
        ids.add("001");
        ids.add("002");
        ids.add("003");

        int totalCost = productService.findTotalCost(ids);
        assertThat(totalCost).isEqualTo(230);
    }

    @Test
    public void should_returnDiscountAndCorrectTotalcost_whenSendingAListWithIds() {
        ArrayList<String> ids = new ArrayList<>();
        ids.add("001");
        ids.add("001");
        ids.add("001");
        ids.add("002");
        ids.add("002");
        ids.add("002");
        ids.add("002");
        ids.add("003");

        int totalCost = productService.findTotalCost(ids);
        assertThat(totalCost).isEqualTo(490);
    }
}

