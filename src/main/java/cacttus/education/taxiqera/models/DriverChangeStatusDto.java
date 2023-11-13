package cacttus.education.taxiqera.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverChangeStatusDto {
    private long id;
    private boolean active;
}
