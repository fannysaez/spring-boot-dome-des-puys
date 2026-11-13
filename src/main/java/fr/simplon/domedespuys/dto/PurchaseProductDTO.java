package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class PurchaseProductDTO {

    @Min(value = 1, message = "La quantité doit être au moins 1")
    public int qty;

    @NotNull(message = "Le prix est obligatoire")
    @DecimalMin(value = "0.0", inclusive = false, message = "Le prix doit être supérieur à 0")
    public BigDecimal price;

    @NotNull(message = "Le produit est obligatoire")
    public Long idProduct;
}