package ro.lucian_lazar.licenta_backend.entity;

import jakarta.persistence.*;
import ro.lucian_lazar.licenta_backend.model.ProductOrder;

import java.util.List;

@Entity
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    // Relație inversă
    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL)
    private List<ProductOrder> produseComandate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ProductOrder> getProduseComandate() {
        return produseComandate;
    }

    public void setProduseComandate(List<ProductOrder> produseComandate) {
        this.produseComandate = produseComandate;
    }
}
