package lk.ijse.edu;

import lk.ijse.edu.entity.Product;
import lk.ijse.edu.repo.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldSaveProduct() {
        Product product = Product.builder().
                id(1L).
                name("Test Product").
                price(100.0).
                quantity(10).
                build();
        Product saveProduct = productRepository.save(product);
        Assertions.assertNotNull(saveProduct.getId());
        Assertions.assertEquals("Test Product", saveProduct.getName());
        Assertions.assertEquals(100.0, saveProduct.getPrice());
        Assertions.assertEquals(10, saveProduct.getQuantity());
    }

    @Test
    void shouldFindAllProducts() {
        Product product1 = Product.builder().
                id(1L).
                name("Product 1").
                price(50.0).
                quantity(5).
                build();
        Product product2 = Product.builder().
                id(2L).
                name("Product 2").
                price(150.0).
                quantity(15).
                build();

        productRepository.save(product1);
        productRepository.save(product2);
        List<Product> products = productRepository.findAll();
        Assertions.assertEquals(2, products.size());
    }
}
