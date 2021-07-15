package com.employees.api.spring.configuration.mockup.domain;

import com.employees.api.employee.domain.Employee;
import com.employees.api.employee.infrastructure.repository.EmployeeRepository;
import com.employees.api.person.domain.Person;
import com.employees.api.person.infrastructure.repository.PersonRepository;
import com.employees.api.position.domain.Position;
import com.employees.api.position.infrastructure.repository.PositionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
public class DataConfig {

    @Bean
    CommandLineRunner loadPersons(PersonRepository personRepository) {
        return args -> personRepository.saveAll(
                Arrays.asList(
                        new Person("John", "Doe", "St 1", "123", "A"),
                        new Person("Jane", "Doe", "St 2", "321", "A"),
                        new Person("Baby", "Doe", "St 3", "213", "B")
                )
        );
    }

    @Bean
    CommandLineRunner loadPositions(PositionRepository positionRepository) {
        return args -> positionRepository.saveAll(
                Arrays.asList(
                        new Position("Dev"),
                        new Position("QA")
                )
        );
    }

    @Bean
    CommandLineRunner loadEmployees(EmployeeRepository employeeRepository) {
        return args -> employeeRepository.saveAll(
                Arrays.asList(
                        new Employee(
                            new Person(1),
                            new Position(1),
                            new BigDecimal(15000)
                        ),
                        new Employee(
                            new Person(2),
                            new Position(2),
                            new BigDecimal(14000)
                        ),
                        new Employee(
                                new Person(3),
                                new Position(1),
                                new BigDecimal(10000)
                        )
                )
        );
    }
}
