package ro.lucian_lazar.licenta_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdusDto {
    private Long id;
    private String denumire;
    private String descriere;
    private String categorie;
    private BigDecimal pret;
    private String imagine;
    private int stoc;
    private int numarVanzari;
}
