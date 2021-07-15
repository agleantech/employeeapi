package com.employees.api.employee.infrastructure.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor
public class EmployeeDto {
    private PersonDto person;
    private PositionDto position;
    private BigDecimal salary;
}
