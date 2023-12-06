package cacttus.education.taxiqera.mappers;

import cacttus.education.taxiqera.entities.DriverEntity;
import cacttus.education.taxiqera.models.DriverDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DriverMapStructMapper extends MapEntityToDto<DriverEntity, DriverDto> {
    DriverMapStructMapper MAPPER = Mappers.getMapper(DriverMapStructMapper.class);
//    @Mapping(source = "name", target = "surname")
//    DriverEntity convert(DriverDto sourceOrder);
}
