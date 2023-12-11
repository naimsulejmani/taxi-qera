package cacttus.education.taxiqera.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
    @Min(value = 0,message = "Nuk guxon te jete vlera me e vogel se zero")
    @Max(value = 9999999999L,message = "BLA BLA")
    private long id;
    @NotBlank(message = "Nuk guxon te jete empty apo blank (vlere me space)!")
    private String name;
    @NotBlank(message = "Nuk guxon te jete empty apo blank (vlere me space)!")
    private String surname;
    @NotBlank(message = "Nuk guxon te jete empty apo blank (vlere me space)!")
    @Length(min = 1, max = 2, message = "Duhen 1 apo 2 karaktere")
    private String licenceCategory;
    private LocalDate birthdate;
    private LocalDate registerDate;
    private boolean active = true;

}
