package com.example.demo.space;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpaceshipDTO {
    private Integer idNumber;
    private String type;
    private String captainFirstName;
    private Integer fuelLeft;
}
