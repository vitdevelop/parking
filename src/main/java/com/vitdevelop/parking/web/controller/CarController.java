package com.vitdevelop.parking.web.controller;

import com.vitdevelop.parking.core.domain.Car;
import com.vitdevelop.parking.core.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by CIC on 28.04.2015.
 */
@RestController
@RequestMapping("/api/v1.0.0/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping
    public Page<Car> getAll(){
        return carService.getCarsPage(new PageRequest(0, Integer.MAX_VALUE));
    }

    @RequestMapping("/{page}/{pageSize}")
    public Page<Car> getCarsPage(@PathVariable("page") int page,
                                 @PathVariable("pageSize") int pagesize){
        return carService.getCarsPage(new PageRequest(page,pagesize));
    }

    @RequestMapping("/{page}/{pageSize}/{sortField}/{direction}")
    public Page<Car> getCarsPageWithSorting(@PathVariable("page") int page,
                                 @PathVariable("pageSize") int pageSize,
                                 @PathVariable("sortField") String sortField,
                                 @PathVariable("direction") Sort.Direction direction){
        return carService.getCarsPage(new PageRequest(page,pageSize,direction,sortField));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Car insertCar(@RequestBody Car car){
        return carService.save(car);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable Long id){
        if (carService.find(id) == null){
            throw new IllegalStateException("Car with id:"+id+" not found.");
        }
        carService.delete(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Car updateCar(@PathVariable Long id, @RequestBody Car car){
        if(carService.find(id) == null){
            throw new IllegalStateException("Car with id:" + id + " not found");
        }
        car.setId(id);
        return carService.save(car);
    }
}
