package training.tdd.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TrainingTddSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingTddSpringApplication.class, args);
    }

}
