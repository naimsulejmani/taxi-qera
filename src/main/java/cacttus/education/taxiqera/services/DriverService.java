package cacttus.education.taxiqera.services;

import cacttus.education.taxiqera.models.DriverChangeStatusDto;
import cacttus.education.taxiqera.models.DriverDto;

import java.util.List;

public interface DriverService {

    boolean add(DriverDto driverDto);

    List<DriverDto> getAll();

    DriverDto getById(long id);

    boolean update(long id, DriverDto updatedDriverDto);

    boolean deleteById(long id);

    boolean changeStatus(long id, DriverChangeStatusDto dto);
}
