package cacttus.education.taxiqera.mappers;

import cacttus.education.taxiqera.entities.DriverEntity;
import cacttus.education.taxiqera.models.DriverChangeStatusDto;
import cacttus.education.taxiqera.models.DriverDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DriverModelMapper implements MapEntityToDto<DriverEntity, DriverDto> {
    private final ModelMapper mapper;

    public DriverModelMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public DriverEntity toEntity(DriverDto item) {
        var entity = mapper.map(item, DriverEntity.class);
//        entity.setAdresa(item.qytety)
        return entity;
    }

    @Override
    public DriverDto toDto(DriverEntity item) {
        return mapper.map(item, DriverDto.class);
    }


    public DriverChangeStatusDto toDriverChangeStatus(DriverEntity entity) {
        return mapper.map(entity, DriverChangeStatusDto.class);
    }

}
