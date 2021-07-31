package aleks.exercise.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Embeddable
public class Assignee {

    private String firstName;

    private String lastName;

    @Email(message = "Please enter a valid e-mail address")
    private String email;

    protected Assignee() {}

    public Assignee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
