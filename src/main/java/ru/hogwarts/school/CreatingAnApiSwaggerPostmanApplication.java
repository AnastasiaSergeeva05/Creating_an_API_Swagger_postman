package ru.hogwarts.school;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@OpenAPIDefinition
//@Component
public class CreatingAnApiSwaggerPostmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreatingAnApiSwaggerPostmanApplication.class, args);
    }

}
