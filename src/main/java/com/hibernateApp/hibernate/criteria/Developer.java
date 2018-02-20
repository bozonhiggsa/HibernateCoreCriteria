package com.hibernateApp.hibernate.criteria;

/**
 * Model
 * @author Ihor Savchenko
 * @version 1.0
 */
public class Developer {

    private int id;
    private String firstName;
    private String lastName;
    private String specialty;
    private int experience;
    private int salary;

    public Developer() {
    }

    public Developer(String firstName, String lastName, String specialty, int experience, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.experience = experience;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nSpecialty: " + specialty +
                "\nExperience: " + experience +
                "\nSalary: " + salary + "\n";
    }
}
