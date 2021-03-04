package com.revature.quizzard.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity @Table(name = "app_users")
public class User {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Role role;

    @Column(name = "confirmed", columnDefinition = "boolean default false")
    private boolean accountConfirmed;

    @JsonIgnore
    @OneToMany(mappedBy = "creator")
    private List<Flashcard> userFlashcards;

    public User() {
        id = 0;
        username = "";
        password = "";
        firstName = "";
        lastName = "";
        role = Role.BASIC_USER;
        accountConfirmed = false;
        userFlashcards = new ArrayList<>();
    }

    public User(String username, String password, String email, String firstName, String lastName) {
        id = 0;
        this.username = (username != null) ? username : "";
        this.password = (password != null) ? password : "";
        this.email = (email != null) ? email : "";
        this.firstName = (firstName != null) ? firstName : "";
        this.lastName = (lastName != null) ? lastName : "";
        role = Role.BASIC_USER;
        accountConfirmed = false;
    }

    public User(String username, String password, String email, String firstName, String lastName, Role role) {
        this(username, password, email, firstName, lastName);
        this.role = role;
        accountConfirmed = false;
    }

    public User(Integer id, String username, String password, String email, String firstName, String lastName, Role role, boolean conf) {
        this(username, password, email, firstName, lastName, role);
        this.id = id;
        accountConfirmed = conf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null) return;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) return;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) return;
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        if (role == null) return;
        this.role = role;
    }

    @JsonIgnore
    public boolean accountConfirmed() {
        return this.accountConfirmed;
    }

    public void setAccountConfirmed(int confValue) {
        this.accountConfirmed = (confValue == 1);
    }

    @JsonIgnore
    public boolean isAdminOrDev() {
        return this.role == Role.ADMIN || this.role == Role.DEV;
    }

    public List<Flashcard> getUserFlashcards() {
        return userFlashcards;
    }

    public void setUserFlashcards(List<Flashcard> userFlashcards) {
        this.userFlashcards = userFlashcards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                accountConfirmed == user.accountConfirmed &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                role == user.role &&
                Objects.equals(userFlashcards, user.userFlashcards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, firstName, lastName, role, accountConfirmed, userFlashcards);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                '}';
    }

}
