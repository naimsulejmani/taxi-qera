package cacttus.education.taxiqera.infrastructure.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CapitalizeValidator.class)
public @interface CapitalizeValidation {

    public String message() default "The first letter should be capitalized";

    //represents group of constraints
    public Class<?>[] groups() default {};

    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}
