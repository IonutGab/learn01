package com.test11.demo1.control;

import com.test11.demo1.data.Car;
import com.test11.demo1.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllCars {

    private final CarService carService;

    public GetAllCars(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car")
    public List<Car> getAllCars() {
        return carService.getCars();
    }

}
