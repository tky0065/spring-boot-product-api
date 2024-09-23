package com.enokdev.tacknoteapi.categorie;



import com.enokdev.tacknoteapi.utils.DataValidator;
import jakarta.annotation.security.PermitAll;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

@PermitAll
@RequiredArgsConstructor
public class CategorieService {


     private final CategorieRepo categorieRepo;
     private final DataValidator<CategorieDto> validator;




    public Categorie saveCategorie(CategorieDto categorieDto) {
        validator.validate(categorieDto);
      Categorie categorie = CategorieDto.toCategorie(categorieDto);
      return categorieRepo.save(categorie);

    }

    public CategorieDto getCategorieById(Long id) {
        return categorieRepo.findById(id).map(CategorieDto::toCategorieDto).orElseThrow(() -> new EntityNotFoundException("Categorie not found"));
    }

    public List<CategorieDto> getAllCategories() {
       return  categorieRepo.findAll().stream().map(CategorieDto::toCategorieDto).collect(Collectors.toList());
    }

    public void deleteCategorie(Long id) {
        categorieRepo.deleteById(id);
    }

}
