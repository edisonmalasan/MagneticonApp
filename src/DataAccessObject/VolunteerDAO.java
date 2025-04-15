package DataAccessObject;

import models.Volunteer;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VolunteerDAO {

    public Volunteer authenticate(String email, String password) {
        String sql = "SELECT * FROM Volunteer WHERE email = ? AND password = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Volunteer volunteer = new Volunteer();
                volunteer.setVolid(rs.getString("volid"));
                volunteer.setFname(rs.getString("fname"));
                volunteer.setLname(rs.getString("lname"));
                volunteer.setEmail(rs.getString("email"));
                volunteer.setRole(rs.getString("role"));

                return volunteer;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
