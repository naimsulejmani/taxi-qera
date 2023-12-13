package cacttus.education.taxiqera.infrastructure.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CapitalizeValidator implements ConstraintValidator<CapitalizeValidation,String> {
    @Override
    public void initialize(CapitalizeValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.charAt(0) >= 'A' && s.charAt(0) <= 'Z';
    }
}
