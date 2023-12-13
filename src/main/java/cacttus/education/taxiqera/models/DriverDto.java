package cacttus.education.taxiqera.models;

import cacttus.education.taxiqera.infrastructure.validations.CapitalizeValidation;
import cacttus.education.taxiqera.infrastructure.validations.MinLocalDateValidation;
import cacttus.education.taxiqera.infrastructure.validations.groups.OnPost;
import cacttus.education.taxiqera.infrastructure.validations.groups.OnPut;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
    @Min(value = 0, message = "Nuk guxon te jete vlera me e vogel se zero")
    @Max(value = 9999999999L, message = "BLA BLA")
    private long id;


    @Null(groups = OnPut.class)
    @NotNull(groups = OnPost.class)
    @NotBlank(message = "Nuk guxon te jete empty apo blank (vlere me space)!",
            groups = OnPost.class)
    @CapitalizeValidation(groups = OnPost.class)
    private String name;

    @NotBlank(message = "Nuk guxon te jete empty apo blank (vlere me space)!")
    private String surname;

    @NotBlank(message = "Nuk guxon te jete empty apo blank (vlere me space)!")
    @Length(min = 1, max = 2, message = "Duhen 1 apo 2 karaktere")
    private String licenceCategory;

    @MinLocalDateValidation(year = 2000, month = 1, day = 1)
    private LocalDate birthdate;

    @MinLocalDateValidation(year = 2020, month = 1, day = 1)
    private LocalDate registerDate;

    private boolean active = true;

}
