package cacttus.education.taxiqera.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
    private long id;
    private String name;
    private String surname;
    private String licenceCategory;
    private LocalDate birthdate;
    private LocalDate registerDate;
    private boolean active = true;

}
