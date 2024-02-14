import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;

import org.example.Product;
import org.example.ProductRepository;
import org.junit.Before;
import org.junit.Test;

public class ProductRepositoryTest {

    private ProductRepository productRepository;
    private Product product;
    private Product[] products;

    @Before
    public void setUp() {
        productRepository = mock(ProductRepository.class);
    }

    @Test
    public void givenId_whenGettingProduct_thenReturnRightProduct() {
        product = new Product("001", "Rolex", 100);
        System.out.println(product);
        System.out.println(productRepository.getProductById("001"));
        when(productRepository.getProductById(anyString())).thenReturn(product);
        assertEquals(productRepository.getProductById("002"), product);
    }

    @Test
    public void a() {
        when(productRepository.getProductById("001")).thenReturn(product);
        assertThat(productRepository.getProductById("001")).isEqualTo(product);

    }

    @Test
    public void whenGettingInstance_thenReturnProducts() {
        products = new Product[]{
            new Product("001", "Rolex", 100),
            new Product("002", "Michael Kors", 80),
            new Product("003", "Swatch", 50),
            new Product("004", "Casio", 30)
        };
        when(ProductRepository.getInstance()).thenReturn(productRepository);
    }
}
