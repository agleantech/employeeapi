package com.employees.api.employee.infrastructure.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class EmployeeFilter {
    private String position;
    private String name;
}
