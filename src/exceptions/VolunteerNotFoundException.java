package exceptions;

public class VolunteerNotFoundException extends RuntimeException {
    public VolunteerNotFoundException(String message) {
        super(message);
    }
}
