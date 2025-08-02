package lk.ijse.edu.controller;

import lk.ijse.edu.entity.Product;
import lk.ijse.edu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(
                productService.getAllProducts()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                productService.getProductById(id)
        );
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.ok(
                productService.createProduct(product)
        );
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return ResponseEntity.ok(
                productService.updateProduct(product)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}