package cacttus.education.taxiqera.services.impls;

import cacttus.education.taxiqera.entities.DriverEntity;
import cacttus.education.taxiqera.mappers.DriverMapStructMapper;
import cacttus.education.taxiqera.mappers.DriverMapper;
import cacttus.education.taxiqera.mappers.DriverModelMapper;
import cacttus.education.taxiqera.mappers.MapEntityToDto;
import cacttus.education.taxiqera.models.DriverChangeStatusDto;
import cacttus.education.taxiqera.models.DriverDto;
import cacttus.education.taxiqera.repositories.DriverRepository;
import cacttus.education.taxiqera.services.DriverService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository repository;
    private final DriverMapper mapper;
    private final ModelMapper modelMapper;
    private final DriverMapStructMapper driverMap;
    private final DriverModelMapper driverModelMapper;
    private final MapEntityToDto<DriverEntity, DriverDto> convert;


    public DriverServiceImpl(DriverRepository repository, DriverMapper mapper, ModelMapper modelMapper,
                             DriverMapStructMapper driverMap, DriverModelMapper driverModelMapper,
                             @Qualifier("driverMapStructMapperImpl") MapEntityToDto<DriverEntity, DriverDto> convert) {
        this.repository = repository;
        this.mapper = mapper;
        this.modelMapper = modelMapper;
        this.driverMap = driverMap;
        this.driverModelMapper = driverModelMapper;
        this.convert = convert;
    }

    @Override
    public boolean add(DriverDto driverDto) {

        // var entity = mapper.toEntity(driverDto);
        // var entity = modelMapper.map(driverDto, DriverEntity.class);
        // var entity = driverMap.toEntity(driverDto);
        var entity = convert.toEntity(driverDto);
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

        var lista = repository.findAllByNameOrSurnameOrderByNameAscSurnameAsc("Naim", "Berisha");


//        return repository.findAll().stream().map(mapper::toDto).toList();
        //  return repository.findAll().stream().map(item -> modelMapper.map(item, DriverDto.class)).toList();
        //return repository.findAll().stream().map(driverMap::toDto).toList();
        return repository.findAll().stream().map(convert::toDto).toList();
    }

    @Override
    public DriverDto getById(long id) {
        var optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty())
            throw new EntityNotFoundException("Driver not found with id " + id);
        var entity = optionalEntity.get();
        //var dto = mapper.toDto(entity);
        //var dto = modelMapper.map(entity, DriverDto.class);
        //var dto = driverMap.toDto(entity);
        var dto = convert.toDto(entity);
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
