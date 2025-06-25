package ro.lucian_lazar.licenta_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComandaDto {
    private Long id;
    private Long idUtilizator;
    private String userName;
    private LocalDateTime dataComanda;
    private String status;
    private BigDecimal total;
    private String adresaLivrare;
    private List<DetaliuComandaDto> detaliiComanda;
}
