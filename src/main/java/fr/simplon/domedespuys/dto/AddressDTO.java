package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class AddressDTO {

    @NotBlank(message = "L'adresse est obligatoire")
    @Length(max = 255, message = "L'adresse ne peut pas faire plus de 255 caractères")
    public String line;

    @Length(max = 255, message = "Le complément d'adresse ne peut pas faire plus de 255 caractères")
    public String extraLine;

    @NotBlank(message = "Le code postal est obligatoire")
    @Pattern(regexp = "^[0-9]{5}$", message = "Le code postal doit contenir 5 chiffres")
    public String zipCode;

    @NotBlank(message = "La ville est obligatoire")
    @Length(max = 150, message = "La ville ne peut pas faire plus de 150 caractères")
    public String city;

    @NotBlank(message = "Le pays est obligatoire")
    @Length(max = 150, message = "Le pays ne peut pas faire plus de 150 caractères")
    public String country;

    @Pattern(regexp = "^[0-9+ .-]{6,20}$", message = "Le téléphone doit être valide")
    public String phone;

    @NotBlank(message = "Le prénom est obligatoire")
    @Length(max = 150, message = "Le prénom ne peut pas faire plus de 150 caractères")
    public String firstname;

    @NotBlank(message = "Le nom est obligatoire")
    @Length(max = 150, message = "Le nom ne peut pas faire plus de 150 caractères")
    public String lastname;
}