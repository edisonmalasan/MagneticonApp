package magneticonapp.controller;

import controllers.AuthController;
import magneticonapp.view.LoginView;
import models.Volunteer;
import views.admin.AdminDashboardView;
import views.volunteer.VolunteerDashboardView;

import java.util.List;

public class MagneticonAppController {
    private final AuthController authController;
    private LoginView loginView;

    public MagneticonAppController() {
        this.authController = new AuthController();
    }

    public void startApplication() {
        loginView = new LoginView(this);
        loginView.setVisible(true);
    }

    public void showLoginView() {
        loginView = new LoginView(this);
        loginView.setVisible(true);
    }

    public void handleLogin(String email, String password) {
        try {
            if (email == null || email.trim().isEmpty() ||
                    password == null || password.trim().isEmpty()) {
                loginView.showErrorMessage("Please enter both email and password");
                return;
            }

            Volunteer volunteer = authController.login(email, password);

            if (volunteer == null) {
                loginView.showErrorMessage("Invalid email or password");
                return;
            }

            loginView.setVisible(false);

            switch (volunteer.getRole().toLowerCase()) {
                case "admin":
                    new AdminDashboardView(this, volunteer).setVisible(true);
                    break;
                case "volunteer":
                    // TODO: for VolunteerDashboardView
//                    new VolunteerDashboardView(this, volunteer).setVisible(true);
                    break;
                default:
                    loginView.showErrorMessage("Unauthorized role");
                    loginView.setVisible(true);
            }
        } catch (Exception e) {
            loginView.showErrorMessage("An error occurred during login");
            e.printStackTrace();
        }
    }

    public void handleLogout() {
        authController.logout();
        loginView.clearFields();
        loginView.setVisible(true);
    }

}
