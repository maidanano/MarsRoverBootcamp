package com.mariano.rover.repository;

import com.mariano.rover.models.Rover;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoverRepository  extends JpaRepository<Rover, Long> {
}
