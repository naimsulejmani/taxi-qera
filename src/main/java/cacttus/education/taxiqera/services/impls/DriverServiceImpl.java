package cacttus.education.taxiqera.services.impls;

import cacttus.education.taxiqera.entities.DriverEntity;
import cacttus.education.taxiqera.mappers.DriverMapper;
import cacttus.education.taxiqera.models.DriverChangeStatusDto;
import cacttus.education.taxiqera.models.DriverDto;
import cacttus.education.taxiqera.repositories.DriverRepository;
import cacttus.education.taxiqera.services.DriverService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository repository;
    private final DriverMapper mapper;


    public DriverServiceImpl(DriverRepository repository, DriverMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public boolean add(DriverDto driverDto) {

        var entity = mapper.toEntity(driverDto);
        repository.save(entity);
        return true;

    }

    @Override
    public List<DriverDto> getAll() {
//        var drivers = repository.findAll();
//        var driverdtos = new ArrayList<DriverDto>();
//        for (var entity:drivers) {
//            var dto = mapper.toDto(entity);
//            driverdtos.add(dto);
//        }
//        return driverdtos;


        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public DriverDto getById(long id) {
        var optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty())
            throw new EntityNotFoundException("Driver not found with id " + id);
        var entity = optionalEntity.get();
        var dto = mapper.toDto(entity);
        return dto;
    }

    @Override
    public boolean update(long id, DriverDto dto) {

        var optionalDriver = repository.findById(id);
        if (optionalDriver.isEmpty())
            throw new EntityNotFoundException("Driver not found with id " + id);

        var entity = optionalDriver.get();
        entity.setRegisterDate(dto.getRegisterDate());
        entity.setSurname(dto.getSurname());
        entity.setBirthdate(dto.getBirthdate());
        entity.setActive(dto.isActive());
        entity.setName(dto.getName());
        entity.setLicenceCategory(dto.getLicenceCategory());

        repository.save(entity);
        return true;
    }

    @Override
    public boolean deleteById(long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean changeStatus(long id, DriverChangeStatusDto dto) {
        var optionalDriver = repository.findById(id);
        if (optionalDriver.isEmpty())
            throw new EntityNotFoundException("Driver not found with id " + id);
        var entity = optionalDriver.get();
        entity.setActive(dto.isActive());
        repository.save(entity);
        return true;
    }
}
