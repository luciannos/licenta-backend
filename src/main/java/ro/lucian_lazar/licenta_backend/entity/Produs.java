package ro.lucian_lazar.licenta_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produse")
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String denumire;

    @Lob
    private String descriere;

    @Column(nullable = false)
    private String categorie;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal pret;

    private String imagine;

    @Column(nullable = false)
    private int stoc;

    @Column(nullable = false)
    private int numarVanzari = 0;
}
