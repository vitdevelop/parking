package com.vitdevelop.parking.core.services;

import com.vitdevelop.parking.core.domain.Car;
import com.vitdevelop.parking.core.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by CIC on 27.04.2015.
 */
@Service
public class MysqlCarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Car> getAll(){

        return carRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Car find(Long id){
        return carRepository.findOne(id);
    }

    @Transactional(readOnly = false)
    @Override
    public Car save(Car car){
        carRepository.save(car);
        return car;
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Long id){
        carRepository.delete(id);
    }

}

