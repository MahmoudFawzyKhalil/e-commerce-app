package gov.iti.jets.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class FeedbackMessage {
    @Id
    @GeneratedValue
    private int id;

    @Size( min = 5, max = 1000 )
    private String message;

    @NotNull
    @Email
    private String email;


    public FeedbackMessage() {
    }

    public FeedbackMessage( String message, String email ) {
        this.message = message;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FeedbackMessage{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
