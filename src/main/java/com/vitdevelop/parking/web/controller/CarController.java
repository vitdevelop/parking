package com.vitdevelop.parking.web.controller;

import com.vitdevelop.parking.core.domain.Car;
import com.vitdevelop.parking.core.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by CIC on 28.04.2015.
 */
@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping
    public List<Car> getCars(){
        return carService.getCars();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Car insertCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable Long id){
        if (carService.findCar(id) == null){
            throw new IllegalStateException("Car with id:"+id+" not found.");
        }
        carService.deleteCar(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Car updateCar(@PathVariable Long id, @RequestBody Car car){
        if(carService.findCar(id) == null){
            throw new IllegalStateException("Car with id:" + id + " not found");
        }
        car.setId(id);
        return carService.saveCar(car);
    }
}
