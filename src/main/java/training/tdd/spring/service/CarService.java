package training.tdd.spring.service;

import org.springframework.stereotype.Service;
import training.tdd.spring.exception.CarNotFoundException;
import training.tdd.spring.model.Car;
import training.tdd.spring.repository.CarRepository;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {

        this.carRepository = carRepository;
    }

    public Car getCarDetails(String s)
    {
        Car car =  carRepository.findByName(s);
        if (car == null)
        {
            throw new CarNotFoundException();
        }
        return car;
    }
}
