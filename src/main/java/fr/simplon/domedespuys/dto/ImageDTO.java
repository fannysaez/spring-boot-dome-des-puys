package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class ImageDTO {

    @NotBlank(message = "L'URL de l'image est obligatoire")
    @Length(max = 255, message = "L'URL ne peut pas faire plus de 255 caractères")
    public String url;

    @Length(max = 150, message = "Le texte alternatif ne peut pas faire plus de 150 caractères")
    public String alt;
}