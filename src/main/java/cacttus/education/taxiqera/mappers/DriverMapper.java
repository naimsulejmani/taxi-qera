package cacttus.education.taxiqera.mappers;

import cacttus.education.taxiqera.entities.DriverEntity;
import cacttus.education.taxiqera.models.DriverChangeStatusDto;
import cacttus.education.taxiqera.models.DriverDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DriverMapper {
    public DriverEntity toEntity(DriverDto from) {
        var to = new DriverEntity();
        to.setId(from.getId());
        to.setName(from.getName());
        to.setBirthdate(from.getBirthdate());
        to.setActive(from.isActive());
        to.setSurname(from.getSurname());
        to.setLicenceCategory(from.getLicenceCategory());
        to.setRegisterDate(from.getRegisterDate());
        to.setCreatedAt(LocalDateTime.now());
        to.setCreatedBy("admin");
        return to;
    }

    public DriverDto toDto(DriverEntity from) {
        var to = new DriverDto();
        to.setId(from.getId());
        to.setName(from.getName());
        to.setBirthdate(from.getBirthdate());
        to.setActive(from.isActive());
        to.setSurname(from.getSurname());
        to.setLicenceCategory(from.getLicenceCategory());
        to.setRegisterDate(from.getRegisterDate());
        return to;
    }

    public DriverChangeStatusDto toChangeStatusDto(DriverEntity from) {
        var to = new DriverChangeStatusDto();
        to.setId(from.getId());
        to.setActive(from.isActive());
        return to;
    }
}
