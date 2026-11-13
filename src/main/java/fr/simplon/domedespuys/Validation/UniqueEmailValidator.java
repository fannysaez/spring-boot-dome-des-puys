package fr.simplon.domedespuys.Validation;

import fr.simplon.domedespuys.Repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null) {
            return true; // laisse @NotBlank gérer le cas vide
        }
        return userRepository.findAll().stream()
                .noneMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }
}