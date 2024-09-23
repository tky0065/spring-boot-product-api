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
    public ResponseEntity<Product> saveCategory(@RequestBody ProductDto productsDto){
        return ResponseEntity.ok(productService.save(productsDto));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getCategory(@PathVariable Long id){
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllproductss(){
        return ResponseEntity.ok(productService.findAllProducts());
    }
}
