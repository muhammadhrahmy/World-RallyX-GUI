package com.example.worldrallycrosschampionship;

public class Driver {
    // declaring all the variables which will be used in the Driver class.
    private String firstName;
    private String lastName;
    private int age;
    private String car;
    private String team;
    private int points;

    // constructor for the above variables.
    public Driver(String firstName, String lastName, int age, String car, String team, int points) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.car = car;
        this.team = team;
        this.points = points;
    }
    // getters for all the variables.
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getCar() {
        return car;
    }
    public String getTeam() {
        return team;
    }
    public int getPoints() {
        return points;
    }

    // the only setter which will be used in SRR method.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setCar(String car) {
        this.car = car;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public void setPoints(int points) {
        this.points = points;
    }
}

