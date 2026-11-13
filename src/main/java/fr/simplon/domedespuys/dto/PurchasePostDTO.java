package fr.simplon.domedespuys.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PurchasePostDTO {

    @NotNull(message = "L'adresse est obligatoire")
    public Long addressId;

    @Valid
    public List<PurchaseProductDTO> purchaseProducts;
}