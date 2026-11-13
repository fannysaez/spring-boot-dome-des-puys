package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.Validation.ValidPurchaseStatus;
import jakarta.validation.constraints.NotBlank;

public class PurchasePutDTO {

    @NotBlank(message = "Le statut est obligatoire")
    @ValidPurchaseStatus
    public String status;
}