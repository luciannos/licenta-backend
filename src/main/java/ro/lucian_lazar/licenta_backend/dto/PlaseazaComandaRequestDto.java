package ro.lucian_lazar.licenta_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlaseazaComandaRequestDto {
    private String adresaLivrare;
    private List<DetaliuComandaDto> detaliiComanda;
} 