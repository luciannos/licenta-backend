package ro.lucian_lazar.licenta_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    @Column(length = 15)
    private String role;


    private String firstName;


    private String lastName;


    private String phone;


    private String address;

    public User() {
    }

    public User(String username, String email, String password, String role, String firstName, String lastName, String phone, String address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = "USER";
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;

    }


    public @NotBlank @Size(max = 20) String getUsername() {
        return this.username;
    }

    public @NotBlank @Size(max = 50) String getEmail() {
        return this.email;
    }

    public @NotBlank @Size(min = 6) String getPassword() {
        return this.password;
    }

    public String getRole() {
        return this.role;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getAddress() {
        return this.address;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(@NotBlank @Size(max = 20) String username) {
        this.username = username;
    }

    public void setEmail(@NotBlank @Size(max = 50) String email) {
        this.email = email;
    }

    public void setPassword(@NotBlank @Size(min = 6) String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
