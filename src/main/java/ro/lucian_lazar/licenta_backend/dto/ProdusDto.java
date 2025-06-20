package ro.lucian_lazar.licenta_backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdusDto {
    private Long id;

    @NotBlank(message = "Denumirea este obligatorie")
    private String denumire;

    @Min(value = 0, message = "Prețul trebuie să fie pozitiv")
    private double pret;

    @Min(value = 0, message = "Stocul nu poate fi negativ")
    private int stoc;

    @NotBlank(message = "Categoria este obligatorie")
    private String categorie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
