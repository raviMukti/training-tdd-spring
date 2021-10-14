package training.tdd.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training.tdd.spring.exception.CarNotFoundException;
import training.tdd.spring.model.Car;
import training.tdd.spring.service.CarService;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars/{name}")
    public Car getCar(@PathVariable String name)
    {
        return carService.getCarDetails(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void carNotFoundHandler(CarNotFoundException ex){

    }
}
