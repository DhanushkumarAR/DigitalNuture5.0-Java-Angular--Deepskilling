package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// This annotation enables auto-configuration, component scanning, and configuration properties
@SpringBootApplication
// We need to explicitly scan our other packages as they are not sub-packages of 'springboot'
@ComponentScan(basePackages = {"springboot", "springdatajpa", "slf4j", "springrest"})
public class Module5Application {

    public static void main(String[] args) {
        SpringApplication.run(Module5Application.class, args);
    }
}
