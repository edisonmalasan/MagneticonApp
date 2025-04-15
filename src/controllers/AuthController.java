package controllers;

import DataAccessObject.VolunteerDAO;
import models.Volunteer;
import utils.SessionManager;

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

        Volunteer volunteer = volunteerDAO.authenticate(email, password);

        if (volunteer != null) {
            SessionManager.setCurrentUser(volunteer);
        }

        return volunteer;
    }

    public void logout() {
        SessionManager.clearSession();
    }

    public boolean isCurrentUserAdmin() {
        return SessionManager.isAdmin();
    }

    public boolean registerVolunteer(Volunteer volunteer) {
        if (volunteer == null) {
            throw new IllegalArgumentException("Volunteer cannot be null");
        }

        //validate fields
        if (volunteer.getEmail() == null || volunteer.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        if (volunteer.getPassword() == null || volunteer.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        if (volunteer.getRole() == null || volunteer.getRole().trim().isEmpty()) {
            volunteer.setRole("volunteer");
        }

        return volunteerDAO.createVolunteer(volunteer);
    }

    public Volunteer getCurrentUser() {
        return SessionManager.getCurrentUser();
    }
}
