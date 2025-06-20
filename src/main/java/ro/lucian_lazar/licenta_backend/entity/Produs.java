package ro.lucian_lazar.licenta_backend.entity;

import jakarta.persistence.*;
import ro.lucian_lazar.licenta_backend.model.ProductOrder;

import java.util.List;

@Entity
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;

    private double pret;

    @OneToMany(mappedBy = "produs", cascade = CascadeType.ALL)
    private List<ProductOrder> comenziProdus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public List<ProductOrder> getComenziProdus() {
        return comenziProdus;
    }

    public void setComenziProdus(List<ProductOrder> comenziProdus) {
        this.comenziProdus = comenziProdus;
    }
}
