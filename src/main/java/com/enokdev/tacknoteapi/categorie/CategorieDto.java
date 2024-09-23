package com.enokdev.tacknoteapi.categorie;


import com.enokdev.tacknoteapi.product.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class CategorieDto {

    private Long id;

    private String nom;
    private String description;
    private List<ProductDto> products;

    public static Categorie toCategorie(CategorieDto categorieDto) {
        return Categorie.builder()
                .id(categorieDto.getId())
                .nom(categorieDto.getNom())
                .description(categorieDto.getDescription())

                .build();
    }


    public static CategorieDto toCategorieDto(Categorie categorie) {
        return CategorieDto.builder()
                .id(categorie.getId())
                .nom(categorie.getNom())
                .description(categorie.getDescription())
                .build();
    }
}
