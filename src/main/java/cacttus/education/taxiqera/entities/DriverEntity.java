package cacttus.education.taxiqera.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drivers")
public class DriverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Column(name = "emri", nullable = false, unique = true)
    private String name;
    private String surname;
    private String licenceCategory;
    private LocalDate birthdate;
    private LocalDate registerDate;
    private boolean active = true;
    private LocalDateTime createdAt;
    private String createdBy;
}
