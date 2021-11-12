package com.example.crudApp.model;

import lombok.Data;

import javax.persistence.*;

@Data //ensures no getters, setters, constructors... need to be typed out
@Entity(name="employee") //make this into a JPA entity, provide a name
public class Employee {

    @Id //a JPA entity must have a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to generate a value for this primary key
    private long id;

    @Column(name="first_name",nullable = false) //to map a field to the column name in the table //nullable = false ensures not null
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;
}
