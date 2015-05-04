package com.vitdevelop.parking.core.services;

import com.vitdevelop.parking.core.domain.Car;

import java.util.List;

/**
 * Created by CIC on 04.05.2015.
 */
public interface CarService {
    List<Car> getAll();
    Car find(Long id);
    Car save(Car car);
    void delete(Long id);
}
