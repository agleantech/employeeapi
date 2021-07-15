package com.employees.api.person.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
        name = "person",
        uniqueConstraints = {
                @UniqueConstraint(name = "person_constraint", columnNames = "id")
        }
)
public class Person implements Serializable {

    private static final long serialVersionUID = 199592359152924883L;

    public Person() {}

    public Person(Integer id) {
        this.id = id;
    }

    public Person(Integer id, String name, String lastName, String address, String cellphone, String cityName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.cellphone = cellphone;
        this.cityName = cityName;
    }

    public Person(String name, String lastName, String address, String cellphone, String cityName) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.cellphone = cellphone;
        this.cityName = cityName;
    }

    @Id
    @SequenceGenerator(name = "person_seq", sequenceName = "person_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    private Integer id;

    private String name;
    private String lastName;
    private String address;
    private String cellphone;
    private String cityName;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
