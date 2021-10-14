package training.tdd.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import training.tdd.spring.exception.CarNotFoundException;
import training.tdd.spring.model.Car;
import training.tdd.spring.repository.CarRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @BeforeEach
    public void setUp() throws Exception{
        carService = new CarService(carRepository);
    }

    @Test
    public void getCarDetails_returnsCarInfo(){
        BDDMockito.given(carRepository.findByName("prius")).willReturn(new Car("prius", "hybrid"));

        Car car = carService.getCarDetails("prius");

        assertEquals(car.getName(), "prius");
        assertEquals(car.getType(), "hybrid");
    }

    @Test
    public void getCarDetails_whenCarNotFound() throws Exception{
        BDDMockito.given(carRepository.findByName("prius")).willReturn(null);

        assertThrows(CarNotFoundException.class, () -> carService.getCarDetails("prius"));
    }
}