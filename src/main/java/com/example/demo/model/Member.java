package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Entity annotation marks a Java class as an entity. Entity represents a table in a database, and each instance of the class corresponds to a row in that table.
@Entity
public class Member {
    //GeneratedValue with @Id used to indicate that its value will be generated automatically.
    //GenerationType is an enumeration that defines the strategies available for generating primary key values when using @GeneratedValue.
    //Common strategies include:
    //
    //IDENTITY: Relies on the database’s auto-increment column feature.
    //SEQUENCE: Uses a database sequence object to generate values.
    //TABLE: Uses a special table in the database to maintain and generate values.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
