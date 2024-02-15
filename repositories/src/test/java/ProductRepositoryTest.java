import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

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
        products = new Product[]{
            new Product("001", "Rolex", 100),
            new Product("002", "Michael Kors", 80),
            new Product("003", "Swatch", 50),
            new Product("004", "Casio", 30)
        };

        for(Product allProduct : products){
            if(allProduct.id().equals("001")){
                product = new Product("001", "Rolex", 100);
            }
        }
        when(productRepository.getProductById("001")).thenReturn(product);
        assertEquals(productRepository.getProductById("001"), product);
    }


    @Test
    public void whenGettingAllProducts_thenReturnAllProductsInRepository() {
        products = new Product[]{
            new Product("001", "Rolex", 100),
            new Product("002", "Michael Kors", 80),
            new Product("003", "Swatch", 50),
            new Product("004", "Casio", 30)
        };
        when(productRepository.getAllProducts()).thenReturn(List.of(products));
        assertEquals(productRepository.getAllProducts(), List.of(products));
    }
}
