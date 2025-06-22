package com.mariano.rover.repository;

import com.mariano.rover.models.Obstacle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObstacleRepository extends JpaRepository<Obstacle, Long> {

}
