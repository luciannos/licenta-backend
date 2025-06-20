package ro.lucian_lazar.licenta_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
@Getter
@Setter
@Entity
@Table(name = "utilizatori")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;

    private String prenume;

    private String gen;

    @Column(unique = true)
    private String email;

    private String parola;

    private String adresa;

    private String telefon;

    private String role = "Normal_User";





    public User() {}

    public User(String nume, String prenume, String gen, String email, String parola, String adresa, String telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return parola;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

}