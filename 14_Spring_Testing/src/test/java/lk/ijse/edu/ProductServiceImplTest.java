package lk.ijse.edu;

import lk.ijse.edu.entity.Product;
import lk.ijse.edu.repo.ProductRepository;
import lk.ijse.edu.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    public void setUp() {
        product=Product.builder()
                .id(1L)
                .name("Test Product")
                .price(10.2)
                .quantity(12)
                .build();
    }

    @Test
    void shouldSaveProduct() {
        //arrange
        when(productRepository.save(any(Product.class))).thenReturn(product);

         //action
        Product savedProduct = productService.createProduct(product);

        //assert
        Assertions.assertNotNull(savedProduct);
        Assertions.assertEquals(product, savedProduct);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void shouldUpdateProduct() {
        //arrange
        Product updateProduct=Product.builder()
                .name("Updated Product")
                .price(20.5)
                .quantity(15)
                .build();
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        //action
        Product result = productService.updateProduct(updateProduct);

        //assert
        Assertions.assertEquals("Update Product", result.getName());
        Assertions.assertEquals(21.22, result.getPrice());
        Assertions.assertEquals(15, result.getQuantity());

        verify(productRepository, times(1)).findById(1L);
    }
}
