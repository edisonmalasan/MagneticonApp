package controllers;

import models.Volunteer;
import DataAccessObject.VolunteerDAO;
import java.util.List;

public class VolunteerController {
    public List<Volunteer> getAllVolunteers() {
        return VolunteerDAO.getAllVolunteers();
    }
}
