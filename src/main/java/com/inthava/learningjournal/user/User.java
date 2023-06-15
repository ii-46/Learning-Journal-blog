package com.inthava.learningjournal.user;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "User")
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_email", columnNames = "email")
        }
)
public class User {
    @Id
    @SequenceGenerator(
            name = "sequence_user",
            sequenceName = "sequence_user",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_user"
    )
    @Column(
            name = "id"
    )
    private Long id;
    @Column(
            name = "username",
            nullable = false,
            columnDefinition = "varchar(30)"
    )
    private String username;
    @Column(
            name = "fullname",
            nullable = false,
            columnDefinition = "varchar(30)"
    )
    private String fullName;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "varchar(30)"
    )
    private String email;
    @Column(
            name = "address",
            columnDefinition = "varchar(30)"
    )
    private String address;
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "varchar(30)"
    )
    private String password;
    @Column(
            name = "join_date",
            nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
    )
    private LocalDateTime joinDate;
    @Column(
            name = "role",
            nullable = false,
            columnDefinition = "varchar(30)"
    )
    private String role;


    public User() {
    }

    public User(Long id, String username, String fullName, String email, String address, String password, LocalDateTime joinDate, String role) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.password = password;
        this.joinDate = joinDate;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(fullName, user.fullName) && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(password, user.password) && Objects.equals(joinDate, user.joinDate) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, fullName, email, address, password, joinDate, role);
    }
}