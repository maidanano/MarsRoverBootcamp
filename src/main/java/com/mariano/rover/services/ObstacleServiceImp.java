package com.mariano.rover.services;

import com.mariano.rover.dto.ObstacleDto;
import com.mariano.rover.models.Obstacle;
import com.mariano.rover.repository.ObstacleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObstacleServiceImp implements ObstacleService{

    @Autowired
    private ObstacleRepository repository;

    @Override
    public List<Obstacle> findAll() {
        return repository.findAll();
    }
}
