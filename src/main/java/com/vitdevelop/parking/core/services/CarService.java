package com.vitdevelop.parking.core.services;

import com.vitdevelop.parking.core.domain.Car;
import com.vitdevelop.parking.core.repository.CarInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CIC on 27.04.2015.
 */
@Service
public class CarService {

    @Autowired
    private CarInterface carInterface;

    public List<Car> getCars(){
        return carInterface.findAll();
    }

    public Car saveCar(Car car){
        carInterface.save(car);
        return car;
    }
}

