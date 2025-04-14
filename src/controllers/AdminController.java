package controllers;

import DataAccessObject.AdminDAO;
import models.Admin;

import java.util.List;


public class AdminController {
    private AdminDAO adminDAO = new AdminDAO();

    public AdminController() {
        this.adminDAO = new AdminDAO();
    }

    private boolean createAdmin(Admin admin) {
        return adminDAO.createAdmin(admin);
    }

    public Admin getAdminByVolunteerId(String volid) {
        return adminDAO.getAdminByVolunteerId(volid);
    }

    public boolean updateAdmin(Admin admin) {
        return adminDAO.updateAdmin(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminDAO.getAllAdmins();
    }
}
