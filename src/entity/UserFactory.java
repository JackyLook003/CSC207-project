package entity;

public interface UserFactory {
    /** Requires: password is valid. */
    User create(String name, String password, String city, String email, int phoneNumber);

}
