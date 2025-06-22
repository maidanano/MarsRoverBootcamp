package com.mariano.rover.services;

import com.mariano.rover.models.Rover;
import org.springframework.stereotype.Service;


public interface RoverService {
    public Rover get();

    void sendCommand(String command);
}
