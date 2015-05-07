package com.vitdevelop.parking.core.services;

import com.vitdevelop.parking.core.domain.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Created by CIC on 04.05.2015.
 */
public interface CarService {
    Page<Car> getCarsPage(PageRequest pageRequest);
    Car find(Long id);
    Car save(Car car);
    void delete(Long id);
}
