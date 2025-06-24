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
public class DetaliuComandaDto {
    private Long idProdus;
    private int cantitate;
    private BigDecimal pretUnitar;
} 