package com.employees.api.position.domain;

import com.employees.api.employee.domain.Employee;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(
        name = "position",
        uniqueConstraints = {
                @UniqueConstraint(name = "position_constraint", columnNames = "id")
        }
)
public class Position implements Serializable {

    private static final long serialVersionUID = -7672716742128209496L;
    @Id
    @SequenceGenerator(name = "position_seq", sequenceName = "position_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_seq")
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "position")
    @OrderBy("salary")
    private List<Employee> employees;

    public Position() {
    }

    public Position(Integer id) {
        this.id = id;
    }

    public Position(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
