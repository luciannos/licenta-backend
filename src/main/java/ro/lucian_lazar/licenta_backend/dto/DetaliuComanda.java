package ro.lucian_lazar.licenta_backend.dto;

import jakarta.persistence.*;
import ro.lucian_lazar.licenta_backend.entity.Comanda;
import ro.lucian_lazar.licenta_backend.entity.Produs;

@Entity
@Table(name = "comanda_produs")
public class DetaliuComanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_comanda;

    private Integer cantitate = 1;

    @ManyToOne
    @JoinColumn(name = "comanda_id", nullable = false)
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name = "produs_id", nullable = false)
    private Produs produs;

    // Getteri și setteri
}
