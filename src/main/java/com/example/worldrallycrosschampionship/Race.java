package com.example.worldrallycrosschampionship;
import java.time.LocalDate;

public class Race {
    // declaring all the variables which will be used in the Race class.
    private final LocalDate date;
    private final String location;
    private final String firstName;
    private final String lastName;
    private final int position;
    private int points;

    // constructor for the above variables.
    public Race(LocalDate date, String location, String firstName, String lastName, int position, int points) {
        this.date = date;
        this.location = location;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.points = points;
    }

    // getters for all the variables.
    public LocalDate getDate() {
        return date;
    }
    public String getLocation() {
        return location;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getPosition() {
        return position;
    }
    public int getPoints() {
        return points;
    }

    // the only setter which will be used in SRR method.
    public void setPoints(int points) {
        this.points = points;
    }
}
