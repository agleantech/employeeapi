package com.employees.api.controller;

import com.employees.api.employee.application.EmployeeService;
import com.employees.api.employee.domain.Employee;
import com.employees.api.employee.infrastructure.controller.EmployeeController;
import com.employees.api.person.domain.Person;
import com.employees.api.position.domain.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    private List<Employee> employeeList;

    @MockBean
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        Employee employee = new Employee(
                new Person(1),
                new Position(1),
                new BigDecimal(10000)
        );
        employeeList = new ArrayList<>();
        employeeList.add(employee);
    }

    @Test
    void list() throws Exception {
        when(employeeService
                .listAll())
                .thenReturn(employeeList);
        mvc.perform(get("/api/v1/employee/list"))
            .andExpect(status().is2xxSuccessful());
    }
}
