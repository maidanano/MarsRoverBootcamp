package com.mariano.rover.dto;

import com.mariano.rover.models.Direction;
import lombok.Data;

@Data
public class RoverDto {
    private Integer x;
    private Integer y;
    private Direction direction;
}
