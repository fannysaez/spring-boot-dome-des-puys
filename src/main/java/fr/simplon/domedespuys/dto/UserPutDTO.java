package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class UserPutDTO {

    @NotBlank(message = "Le prénom est obligatoire")
    @Length(max = 150, message = "Le prénom ne peut pas faire plus de 150 caractères")
    public String firstname;

    @NotBlank(message = "Le nom est obligatoire")
    @Length(max = 150, message = "Le nom ne peut pas faire plus de 150 caractères")
    public String lastname;

    @Pattern(regexp = "^[0-9+ .-]{6,20}$", message = "Le téléphone doit être valide")
    public String phone;
}