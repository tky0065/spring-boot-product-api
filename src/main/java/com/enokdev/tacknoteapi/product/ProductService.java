package com.enokdev.tacknoteapi.product;



import com.enokdev.tacknoteapi.utils.DataValidator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {


  private final ProductRepo productRepo;
  private  final DataValidator<ProductDto> validator;


    public Product save(ProductDto productDto) {
        validator.validate(productDto);
        Product product = ProductDto.toProduct(productDto);
        return productRepo.save(product);
    }

    public List<ProductDto> findAllProducts() {
        return productRepo.findAll().stream().map(ProductDto::toProductDto).collect(Collectors.toList());
    }

    public ProductDto findProductById(Long id) {
        return productRepo.findById(id).map(ProductDto::toProductDto).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }
}
