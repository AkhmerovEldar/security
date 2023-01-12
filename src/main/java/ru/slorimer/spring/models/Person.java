package ru.slorimer.spring.models;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Person")
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull(message = "empty")
    @Size(min = 2, max = 15, message = "name between 2 and 15 characters")
    private String name;

    @Column(name = "year_of_birth")
    @NotNull(message = "empty")
    @Min(value = 1920, message = "u already dead")
    @Max(value = 2022, message = "small nigga")
    private int year_of_birth;

    @Column(name = "password")
    @NotNull(message = "empty")
    private String password;

    public Person(){}

    public Person(String name, int year_of_birth) {
        this.name = name;
        this.year_of_birth = year_of_birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", year_of_birth=" + year_of_birth +
                '}';
    }
}
