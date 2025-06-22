package com.mariano.rover.services;

import com.mariano.rover.controllers.RoverController;
import com.mariano.rover.dto.CommandDto;
import com.mariano.rover.models.Rover;
import com.mariano.rover.repository.RoverRepository;
import com.mariano.rover.services.RoverService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static com.mariano.rover.models.Direction.NORTH;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RoverServiceImpTest {


    @Mock
    private RoverRepository roverRepository;

    @InjectMocks
    private RoverServiceImp service;


    @Test
    public void whenSendCommand_callService() {
        Rover rover = new Rover();
        rover.setX(5);
        rover.setY(5);
        rover.setDirection(NORTH);
        List<Rover> roverList = new ArrayList<>();
        roverList.add(rover);

        when(roverRepository.findAll()).thenReturn(roverList);

        service.sendCommand("F");
        Rover finalRover = new Rover();
        finalRover.setX(5);
        finalRover.setY(4);
        finalRover.setDirection(NORTH);


        verify(roverRepository, times(1)).save(finalRover);

    }

        /*
        CommandDto commandDto = new CommandDto();
        List<String> commandsList = new ArrayList<>();
        commandsList.add("F");
        commandDto.setCommands(commandsList);


        controller.sendCommand(commandDto);

        verify(roverService, times(1)).sendCommand("F");

         */


}