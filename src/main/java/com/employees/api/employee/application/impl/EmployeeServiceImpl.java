package com.employees.api.employee.application.impl;

import com.employees.api.employee.application.EmployeeService;
import com.employees.api.employee.domain.Employee;
import com.employees.api.employee.infrastructure.controller.dto.EmployeeFilter;
import com.employees.api.employee.infrastructure.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void create(Employee employee) throws Exception {
        try {
            employeeRepository.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Employee could not be saved");
        }
    }

    @Override
    public void update(Integer id, Employee employee) throws Exception {
        try {
            if ( employeeRepository.existsById(id) ) {
                employee.setId(id);
                employeeRepository.save(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Employee could not be updated");
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            employeeRepository.delete(new Employee(id));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Employee could not be deleted");
        }
    }

    @Override
    public List<Employee> listAll() {
        try {
            return employeeRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public List<Employee> listAllFilter(EmployeeFilter filter) {
        try {
            List<Employee> employeeList = employeeRepository.findAll();
            if ( (!isNull(filter.getName()) && !filter.getName().isEmpty()) && (!isNull(filter.getPosition()) && !filter.getPosition().isEmpty()) )
                return employeeList
                        .stream()
                        .filter(employee -> employee.getPerson().getName().equalsIgnoreCase(filter.getName()))
                        .filter(employee -> employee.getPosition().getName().equalsIgnoreCase(filter.getPosition()))
                        .collect(Collectors.toList());
            if ( !isNull(filter.getName()) && !filter.getName().isEmpty() )
                return employeeList
                        .stream()
                        .filter(employee -> employee.getPerson().getName().equalsIgnoreCase(filter.getName()))
                        .collect(Collectors.toList());
            if ( !isNull(filter.getPosition()) && !filter.getPosition().isEmpty() )
                return employeeList
                        .stream()
                        .filter(employee -> employee.getPosition().getName().equalsIgnoreCase(filter.getPosition()))
                        .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
