package ro.lucian_lazar.licenta_backend.model;

import jakarta.persistence.*;
import ro.lucian_lazar.licenta_backend.entity.Comanda;
import ro.lucian_lazar.licenta_backend.entity.Produs;

@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_comanda;

    private int cantitate;

    @ManyToOne
    @JoinColumn(name = "comanda_id")
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name = "produs_id")
    private Produs produs;

    public Long getId_comanda() {
        return id_comanda;
    }

    public void setId_comanda(Long id_comanda) {
        this.id_comanda = id_comanda;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }
}
