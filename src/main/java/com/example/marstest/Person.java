package com.example.marstest;
import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "surName")
    private String surName;

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Person() {

    }

    public Person(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

     @Override
    public String toString() {
        return "Person [id=" + id + ", firstName=" + firstName + ", surName=" + surName + "]";
    }

}
