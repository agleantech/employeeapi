package com.employees.api.employee.application;

import com.employees.api.employee.domain.Employee;
import com.employees.api.employee.infrastructure.controller.dto.EmployeeFilter;

import java.util.List;

public interface EmployeeService {

    void create(Employee employee) throws Exception;

    void update(Integer id, Employee employee) throws Exception;

    void delete(Integer id) throws Exception;

    List<Employee> listAll();

    List<Employee> listAllFilter(EmployeeFilter filter);
}
