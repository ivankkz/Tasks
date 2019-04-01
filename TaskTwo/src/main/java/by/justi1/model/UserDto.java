package by.justi1.model;

import java.time.LocalDate;

public class UserDto {
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate dateOfBirthday;
    private String password;

    public UserDto(String firstname, String lastname, String email, LocalDate dateOfBirthday, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dateOfBirthday = dateOfBirthday;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public String getPassword() {
        return password;
    }
}
