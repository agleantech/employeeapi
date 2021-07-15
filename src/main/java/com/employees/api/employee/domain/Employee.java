package com.employees.api.employee.domain;

import com.employees.api.person.domain.Person;
import com.employees.api.position.domain.Position;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(
        name = "employee",
        uniqueConstraints = {
                @UniqueConstraint(name = "employee_constraint", columnNames = "id")
        }
)
public class Employee implements Serializable {

    private static final long serialVersionUID = 3424063057307187689L;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Person person, Position position, BigDecimal salary) {
        this.person = person;
        this.position = position;
        this.salary = salary;
    }

    @Id
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    private Integer id;

    @Column(precision = 20, scale = 2)
    private BigDecimal salary;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person", referencedColumnName = "id")
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "position",
            foreignKey = @ForeignKey(name = "fk_position_employee")
    )
    @JsonBackReference
    private Position position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
