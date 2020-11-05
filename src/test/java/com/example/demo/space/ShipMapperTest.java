package com.example.demo.space;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ShipMapperTest {

    @Autowired
    SpaceShipRepository spaceShipRepository;

    @Autowired
    ShipMapper shipMapper;

    @Test
    public void fromDto() {
//        Prepare data
        spaceShipRepository.deleteAll();
        SpaceshipEntity savedEntity = spaceShipRepository.save(
                new SpaceshipEntity(null, "Pyramid", "Mike", 25)
        );
        System.out.println(savedEntity);

//        The test
        SpaceshipDTO spaceshipDTO = shipMapper.toDto(savedEntity);
        spaceshipDTO.setCaptainFirstName(null);
        spaceshipDTO.setType(null);
        spaceshipDTO.setFuelLeft(100);

        SpaceshipEntity spaceshipEntity = shipMapper.fromTwoOther(spaceshipDTO, savedEntity);

        System.out.println(spaceshipEntity);
        spaceShipRepository.save(spaceshipEntity);
    }
}