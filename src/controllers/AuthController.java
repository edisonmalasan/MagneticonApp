package controllers;

import DataAccessObject.VolunteerDAO;
import models.Volunteer;

public class AuthController {
    private VolunteerDAO volunteerDAO = new VolunteerDAO();

    public AuthController() {
        this.volunteerDAO = new VolunteerDAO();
    }

    public Volunteer login(String email, String password) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        Volunteer volunteer = volunteerDAO.
    }

}
