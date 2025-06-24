package ro.lucian_lazar.licenta_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cos_cumparaturi")
public class Cos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilizator", nullable = false)
    private User utilizator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produs", nullable = false)
    private Produs produs;

    @Column(nullable = false)
    private int cantitate;
} 