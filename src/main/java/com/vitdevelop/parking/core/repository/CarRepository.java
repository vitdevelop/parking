package com.vitdevelop.parking.core.repository;

import com.vitdevelop.parking.core.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by CIC on 27.04.2015.
 */
@RepositoryRestResource(collectionResourceRel = "car", path = "car")
public interface CarRepository extends JpaRepository<Car,Long> {
    
}
