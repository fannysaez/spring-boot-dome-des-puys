package fr.simplon.domedespuys.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.List;

public class ProductPostDTO {

    @NotBlank(message = "Le label du produit est obligatoire")
    @Length(max = 150, message = "Le label ne peut pas faire plus de 150 caractères")
    public String label;

    @NotBlank(message = "La description est obligatoire")
    @Length(max = 1000, message = "La description ne peut pas faire plus de 1000 caractères")
    public String description;

    @NotNull(message = "Le prix est obligatoire")
    @DecimalMin(value = "0.0", inclusive = false, message = "Le prix doit être supérieur à 0")
    public BigDecimal price;

    @NotBlank(message = "La marque est obligatoire")
    @Length(max = 150, message = "La marque ne peut pas faire plus de 150 caractères")
    public String brand;

    @Valid
    public List<ImageDTO> images;
}