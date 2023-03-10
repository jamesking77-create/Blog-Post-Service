package data.model;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;

public class User {

    private int id;
    private String firstName;
    private String LastName;
    private String userName;
    private String password;
    private LocalDateTime dateRegistered;

    public LocalDateTime getDateRegistered() {
        return dateRegistered = LocalDateTime.now();
    }

    public void setDateRegistered(LocalDateTime dateRegistered) {
        this.dateRegistered = dateRegistered;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
