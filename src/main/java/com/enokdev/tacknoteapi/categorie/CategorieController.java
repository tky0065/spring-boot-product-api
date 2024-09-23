package com.enokdev.tacknoteapi.categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {
    @Autowired
    CategorieService categorieService;

    @PostMapping("/categorie")
    public ResponseEntity<Categorie> saveCategory(@RequestBody CategorieDto categorieDto){
        return ResponseEntity.ok(categorieService.saveCategorie(categorieDto));
    }

    @GetMapping("/categorie/{id}")
    public ResponseEntity<CategorieDto> getCategory(@PathVariable Long id){
        return ResponseEntity.ok(categorieService.getCategorieById(id));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategorieDto>> getAllCategories(){
        return ResponseEntity.ok(categorieService.getAllCategories());
    }
}
