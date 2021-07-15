package com.employees.api.employee.infrastructure.controller;

import com.employees.api.employee.application.EmployeeService;
import com.employees.api.employee.domain.Employee;
import com.employees.api.employee.infrastructure.controller.dto.EmployeeDto;
import com.employees.api.employee.infrastructure.controller.dto.EmployeeFilter;
import com.employees.api.person.domain.Person;
import com.employees.api.position.domain.Position;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "api/v1/employee")
    public void createEmployee(@RequestBody EmployeeDto input) throws Exception {
        employeeService.create(
                new Employee(
                        new Person(input.getPerson().getId()),
                        new Position(input.getPosition().getId()),
                        input.getSalary())
        );
    }

    @PutMapping(path = "api/v1/employee/{id}")
    public void updateEmployee(@RequestBody EmployeeDto input, @PathVariable("id") Integer id) throws Exception {
        employeeService.update(
                id,
                new Employee(
                        new Person(input.getPerson().getId()),
                        new Position(input.getPosition().getId()),
                        input.getSalary())
        );
    }

    @DeleteMapping(path = "api/v1/employee/{id}")
    public void deleteEmployee(@PathVariable("id") Integer id) throws Exception {
        employeeService.delete(id);
    }

    @GetMapping(path = "api/v1/employee/list")
    public List<Employee> listEmployees(@RequestBody(required = false) EmployeeFilter filter) {
        if ( filter != null )
            return employeeService.listAllFilter(filter);
        else
            return employeeService.listAll();
    }
}
