package ro.lucian_lazar.licenta_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "utilizatori")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nume;

    @Column(nullable = false)
    private String prenume;

    @Column
    private String gen;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String parola;

    @Column(nullable = false)
    private String role = "USER";

    @CreationTimestamp
    @Column(name = "data_inregistrare", nullable = false, updatable = false)
    private LocalDateTime dataInregistrare;

    @Column
    private String telefon;

    @Column
    private String adresa;
}
