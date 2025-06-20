package ro.lucian_lazar.licenta_backend.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dataInreg")
    private java.sql.Timestamp created;
    @Column(name = "numeDeFamilie")
    private String firstName;
    @Column(name = "prenume")
    private String lastName;

    @Column(name = "gen")
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "parola")
    private String password;

    @Column(name = "tipUtilizator")
    private String role;
    @Column(name = "numarTelefon")
    private String phone;
    @Column(name = "adresa")
    private String address;

    @OneToMany(mappedBy = "utilizator", cascade = CascadeType.ALL)
    private List<ComandaDto> comenzi;
}