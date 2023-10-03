package com.example.worldrallycrosschampionship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UDDDriverTest {
    Controller controller = new Controller();
    @Test
    public void emptyUpdateFirstNameShouldBeInvalid() {
        assertFalse(controller.isUpdateFirstNameValid(""));
    }
    @Test
    public void notStringUpdateFirstNameShouldBeInvalid() {
        assertFalse(controller.isUpdateFirstNameValid("456"));
    }
    @Test
    public void emptyUpdateLastNameShouldBeInvalid() {
        assertFalse(controller.isUpdateLastNameValid(""));
    }
    @Test
    public void notStringUpdateLastNameShouldBeInvalid() {
        assertFalse(controller.isUpdateLastNameValid("456"));
    }
    @Test
    public void emptyNewFirstNameShouldBeInvalid() {
        assertFalse(controller.isNewFirstNameValid(""));
    }
    @Test
    public void notStringNewFirstNameShouldBeInvalid() {
        assertFalse(controller.isNewFirstNameValid("456"));
    }
    @Test
    public void emptyNewLastNameShouldBeInvalid() {
        assertFalse(controller.isNewLastNameValid(""));
    }
    @Test
    public void notStringNewLastNameShouldBeInvalid() {
        assertFalse(controller.isNewLastNameValid("456"));
    }
    @Test
    public void emptyNewAgeShouldBeInvalid() {
        assertFalse(controller.isNewAgeValid(""));
    }
    @Test
    public void notIntegerNewAgeShouldBeInvalid() {
        assertFalse(controller.isNewAgeValid("muhammadh"));
    }
    @Test
    public void emptyNewCarShouldBeInvalid() {
        assertFalse(controller.isNewCarValid(""));
    }
    @Test
    public void emptyNewTeamShouldBeInvalid() {
        assertFalse(controller.isNewTeamValid(""));
    }
    @Test
    public void emptyNewPointsShouldBeInvalid() {
        assertFalse(controller.isNewPointsValid(""));
    }
    @Test
    public void notIntegerNewPointsShouldBeInvalid() {
        assertFalse(controller.isNewPointsValid("muhammadh"));
    }
}