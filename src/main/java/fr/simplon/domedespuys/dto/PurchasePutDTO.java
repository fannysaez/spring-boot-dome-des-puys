package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;

public class PurchasePutDTO {

    @NotBlank(message = "Le statut est obligatoire")
    public String status;
}