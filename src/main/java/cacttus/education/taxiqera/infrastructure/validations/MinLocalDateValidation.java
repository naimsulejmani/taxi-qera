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
@Constraint(validatedBy = MinLocalDateValidator.class)
public @interface MinLocalDateValidation {
    //attributet


    public int day() default 1;

    public int month() default 1;

    public int year() default 1900;

    //error message
    public String message() default "Date is not valid, provide day/month/year";

    //represents group of constraints
    public Class<?>[] groups() default {};

    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}
