package com.vitdevelop.parking.core.repository;

import com.vitdevelop.parking.core.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by CIC on 27.04.2015.
 */
public interface CarInterface extends JpaRepository<Car,Long> {
    
}
