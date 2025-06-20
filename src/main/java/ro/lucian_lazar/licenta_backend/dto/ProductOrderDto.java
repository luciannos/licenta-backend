package ro.lucian_lazar.licenta_backend.dto;

public class ProductOrderDto {
    private Long id_comanda;
    private int cantitate;
    private Long comandaId;
    private Long produsId;

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

    public Long getComandaId() {
        return comandaId;
    }

    public void setComandaId(Long comandaId) {
        this.comandaId = comandaId;
    }

    public Long getProdusId() {
        return produsId;
    }

    public void setProdusId(Long produsId) {
        this.produsId = produsId;
    }
}
