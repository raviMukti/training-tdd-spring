package training.tdd.spring.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import training.tdd.spring.model.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByName_shouldReturnCar() throws Exception{

        testEntityManager.persistAndFlush(new Car(1L, "prius", "hybrid"));
        testEntityManager.clear();

        Car car = carRepository.findByName("prius");

        assertEquals(car.getName(), "prius");
    }
}