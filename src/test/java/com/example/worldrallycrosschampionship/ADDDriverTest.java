package com.example.worldrallycrosschampionship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ADDDriverTest {
    Controller controller = new Controller();
    @Test
    public void emptyFirstNameShouldBeInvalid() {
        assertFalse(controller.isFirstNameValid(""));
    }
    @Test
    public void notStringFirstNameShouldBeInvalid() {
        assertFalse(controller.isFirstNameValid("456"));
    }
    @Test
    public void emptyLastNameShouldBeInvalid() {
        assertFalse(controller.isLastNameValid(""));
    }
    @Test
    public void notStringLastNameShouldBeInvalid() {
        assertFalse(controller.isLastNameValid("456"));
    }
    @Test
    public void emptyAgeShouldBeInvalid() {
        assertFalse(controller.isAgeValid(""));
    }
    @Test
    public void notIntegerAgeShouldBeInvalid() {
        assertFalse(controller.isAgeValid("muhammadh"));
    }
    @Test
    public void emptyCarShouldBeInvalid() {
        assertFalse(controller.isCarValid(""));
    }
    @Test
    public void emptyTeamShouldBeInvalid() {
        assertFalse(controller.isTeamValid(""));
    }
    @Test
    public void emptyPointsShouldBeInvalid() {
        assertFalse(controller.isPointsValid(""));
    }
    @Test
    public void notIntegerPointsShouldBeInvalid() {
        assertFalse(controller.isPointsValid("muhammadh"));
    }
}