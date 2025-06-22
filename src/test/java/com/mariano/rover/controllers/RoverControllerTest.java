package com.mariano.rover.controllers;

import com.mariano.rover.dto.CommandDto;
import com.mariano.rover.services.RoverService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RoverControllerTest {

    @Mock
    private RoverService roverService;

    @InjectMocks
    private RoverController controller;


    @Test
    public void whenSendCommand_callService() {

        CommandDto commandDto = new CommandDto();
        List<String> commandsList = new ArrayList<>();
        commandsList.add("F");
        commandDto.setCommands(commandsList);


        controller.sendCommand(commandDto);

        verify(roverService, times(1)).sendCommand("F");

    }

    @Test
    public void whenSendCommand_FRF_callService() {

        CommandDto commandDto = new CommandDto();
        List<String> commandsList = new ArrayList<>();
        commandsList.add("F");
        commandsList.add("R");
        commandsList.add("F");
        commandDto.setCommands(commandsList);


        controller.sendCommand(commandDto);

        verify(roverService, times(3)).sendCommand(any());

    }
}
