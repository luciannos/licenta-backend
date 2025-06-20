package ro.lucian_lazar.licenta_backend.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comanda_produs")
@Getter
@Setter
public class ProductOrderEntity {

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


}
