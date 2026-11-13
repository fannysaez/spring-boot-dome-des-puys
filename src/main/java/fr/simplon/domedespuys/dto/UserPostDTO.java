package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.Validation.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UserPostDTO {

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email doit être valide")
    @UniqueEmail
    public String email;

    @NotBlank(message = "Le mot de passe est obligatoire")
    @Length(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères")
    public String password;

    @NotBlank(message = "Le prénom est obligatoire")
    @Length(max = 150, message = "Le prénom ne peut pas faire plus de 150 caractères")
    public String firstname;

    @NotBlank(message = "Le nom est obligatoire")
    @Length(max = 150, message = "Le nom ne peut pas faire plus de 150 caractères")
    public String lastname;
}