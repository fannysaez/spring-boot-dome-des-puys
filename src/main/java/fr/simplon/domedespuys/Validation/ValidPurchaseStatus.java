package fr.simplon.domedespuys.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PurchaseStatusValidator.class)
public @interface ValidPurchaseStatus {
    String message() default "Le statut doit être l'un des suivants : PENDING, PAID, SHIPPED, DELIVERED, CANCELLED";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}