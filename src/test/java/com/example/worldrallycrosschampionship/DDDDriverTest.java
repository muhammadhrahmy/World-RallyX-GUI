package com.example.worldrallycrosschampionship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DDDDriverTest {
    Controller controller = new Controller();
    @Test
    public void emptyDeleteFirstNameShouldBeInvalid() {
        assertFalse(controller.isDeleteFirstNameValid(""));
    }
    @Test
    public void notStringDeleteFirstNameShouldBeInvalid() {
        assertFalse(controller.isDeleteFirstNameValid("456"));
    }
    @Test
    public void emptyDeleteLastNameShouldBeInvalid() {
        assertFalse(controller.isDeleteLastNameValid(""));
    }
    @Test
    public void notStringDeleteLastNameShouldBeInvalid() {
        assertFalse(controller.isDeleteLastNameValid("456"));
    }
}