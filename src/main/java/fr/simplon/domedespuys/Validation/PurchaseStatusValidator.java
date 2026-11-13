package fr.simplon.domedespuys.Validation;

import fr.simplon.domedespuys.Entity.EnumPurchaseStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PurchaseStatusValidator implements ConstraintValidator<ValidPurchaseStatus, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // laisse @NotBlank gérer le cas vide
        }
        for (EnumPurchaseStatus status : EnumPurchaseStatus.values()) {
            if (status.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}