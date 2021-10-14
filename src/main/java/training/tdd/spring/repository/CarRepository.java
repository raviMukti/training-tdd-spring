package training.tdd.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training.tdd.spring.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByName(String name);
}
