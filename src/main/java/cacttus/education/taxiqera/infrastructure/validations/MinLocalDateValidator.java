package cacttus.education.taxiqera.infrastructure.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class MinLocalDateValidator implements ConstraintValidator<MinLocalDateValidation, LocalDate> {

    private int minDay;
    private int minMonth;
    private int minYear;

    @Override
    public void initialize(MinLocalDateValidation constraintAnnotation) {
        minDay = constraintAnnotation.day();
        minMonth = constraintAnnotation.month();
        minYear = constraintAnnotation.year();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate minDate = LocalDate.of(minYear, minMonth, minDay);
        return localDate.isAfter(minDate) || localDate.equals(minDate);
    }
}
