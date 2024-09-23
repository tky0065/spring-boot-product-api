package com.enokdev.tacknoteapi.product;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;



    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDto productsDto){
        return ResponseEntity.ok(productService.save(productsDto));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.accepted().build();

    }
}
