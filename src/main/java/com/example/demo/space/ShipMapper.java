package com.example.demo.space;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import javax.swing.*;

@Mapper(componentModel = "spring")
public interface ShipMapper {
//    ShipMapper MAPPER = Mappers.getMapper( ShipMapper.class );

    @Mapping(source = "idNumber", target = "id")
    @Mapping(source = "type", target="model")
    @Mapping(source = "captainFirstName", target="captain")
    @Mapping(source = "fuelLeft", target="fuel")
    SpaceshipEntity fromDto(SpaceshipDTO dto);

    @Mapping(source = "idNumber", target = "id")
    @Mapping(source = "type", target="model",
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "captainFirstName", target="captain",
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "fuelLeft", target="fuel",
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SpaceshipEntity fromTwoOther(SpaceshipDTO dto, @MappingTarget SpaceshipEntity entity);

    @InheritInverseConfiguration(name="fromDto")
    SpaceshipDTO toDto(SpaceshipEntity entity);


}
